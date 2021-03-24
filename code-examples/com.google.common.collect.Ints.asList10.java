public void serialize(TypeToken<?> type, int[] obj, ConfigurationNode value) throws ObjectMappingException {
    List<Integer> bytes = Ints.asList(obj);
    value.setValue(ttlb, bytes);
}