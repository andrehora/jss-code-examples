static void formatConfiguration(StringBuilder sb, AttributeContainer fromConfigurationAttributes, AttributesSchema consumerSchema, List<ConfigurationMetadata> matches, Set<String> requestedAttributes, int maxConfLength, final String conf) {
    Optional<ConfigurationMetadata> match = Iterables.tryFind(matches, new Predicate<ConfigurationMetadata>() {
        @Override
        public boolean apply(ConfigurationMetadata input) {
            return conf.equals(input.getName());
        }
    });
    if (match.isPresent()) {
        AttributeContainer producerAttributes = match.get().getAttributes();
        Set<Attribute<?>> targetAttributes = producerAttributes.keySet();
        Set<String> targetAttributeNames = Sets.newTreeSet(Iterables.transform(targetAttributes, ATTRIBUTE_NAME));
        Set<Attribute<?>> allAttributes = Sets.union(fromConfigurationAttributes.keySet(), producerAttributes.keySet());
        Set<String> commonAttributes = Sets.intersection(requestedAttributes, targetAttributeNames);
        Set<String> consumerOnlyAttributes = Sets.difference(requestedAttributes, targetAttributeNames);
        sb.append("   ").append("- Configuration '").append(StringUtils.rightPad(conf + "'", maxConfLength + 1)).append(" :");
        List<Attribute<?>> sortedAttributes = Ordering.usingToString().sortedCopy(allAttributes);
        List<String> values = new ArrayList<String>(sortedAttributes.size());
        formatAttributes(sb, fromConfigurationAttributes, consumerSchema, producerAttributes, commonAttributes, consumerOnlyAttributes, sortedAttributes, values);
    }
}