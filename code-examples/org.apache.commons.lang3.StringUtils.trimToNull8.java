public String[] deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
    final List<String> list = new ArrayList<>();
    final JsonNode node = jsonParser.readValueAsTree();
    if (node.isArray()) {
        final Iterator elements = node.elements();
        while (elements.hasNext()) {
            final JsonNode childNode = (JsonNode) elements.next();
            final String value = StringUtils.trimToNull(childNode.asText());
            if (value != null) {
                list.add(value);
            }
        }
    }
    if (list.size() == 0) {
        return null;
    } else {
        return list.toArray(new String[list.size()]);
    }
}