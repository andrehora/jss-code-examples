private static Object generateMapType(ServiceDefinition def, TypeDefinition td, MetadataType metadataType,
                                      Set<String> resolvedTypes) {
    String keyType = StringUtils.substringAfter(td.getType(), "<");
    keyType = StringUtils.substringBefore(keyType, ",");
    keyType = StringUtils.strip(keyType);
    keyType = StringUtils.isNotEmpty(keyType) ? keyType : "java.lang.Object";
    Object key = generateType(def, keyType, metadataType, resolvedTypes);

    String valueType = StringUtils.substringAfter(td.getType(), ",");
    valueType = StringUtils.substringBefore(valueType, ">");
    valueType = StringUtils.strip(valueType);
    valueType = StringUtils.isNotEmpty(valueType) ? valueType : "java.lang.Object";
    Object value = generateType(def, valueType, metadataType, resolvedTypes);

    Map<Object, Object> map = new HashMap<>();
    map.put(key, value);
    return map;
}