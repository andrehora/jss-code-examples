private <T> ValueExtractor provideExtractorForValue(Class<T> clazz, int target, List<String> chainOfProperties) {
    Class<?> propertyClass = clazz;
    List<Integer> indices = Lists.newArrayList();

    for (String property : chainOfProperties) {
        Field field;
        try {
            field = clazz.getDeclaredField(property);
        } catch (NoSuchFieldException e) {
            throw new InvalidQueryException(e);
        }

        PortableProperty portablePropertyAnnotation = field.getAnnotation(PortableProperty.class);
        if (portablePropertyAnnotation == null) {
            throw new InvalidQueryException("");
        }

        // TODO add support for customs codecs some day ;)
        int index = portablePropertyAnnotation.value();
        indices.add(index);
        propertyClass = field.getDeclaringClass();
    }

    return new PofExtractor<>(propertyClass, new SimplePofPath(Ints.toArray(indices)), target);
}