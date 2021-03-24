public static int[] getDimensions(Object array) {
    int[] dimensions = new int[0];
    Class<?> type = array.getClass();
    while (type.isArray()) {
        int length = array != null ? Array.getLength(array) : 0;
        dimensions = Ints.concat(dimensions, new int[] { length });
        array = length > 0 ? Array.get(array, 0) : null;
        type = type.getComponentType();
    }
    return dimensions;
}