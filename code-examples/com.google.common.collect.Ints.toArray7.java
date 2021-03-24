private Object toArray(Class<?> componentType, List<Object> values) {
    if (componentType == boolean.class) {
        return Booleans.toArray((Collection) values);
    } else if (componentType == byte.class) {
        return Bytes.toArray((Collection) values);
    } else if (componentType == short.class) {
        return Shorts.toArray((Collection) values);
    } else if (componentType == int.class) {
        return Ints.toArray((Collection) values);
    } else if (componentType == long.class) {
        return Longs.toArray((Collection) values);
    } else if (componentType == float.class) {
        return Floats.toArray((Collection) values);
    } else if (componentType == double.class) {
        return Doubles.toArray((Collection) values);
    } else if (componentType == char.class) {
        return Chars.toArray((Collection) values);
    }
    return values.toArray((Object[]) Array.newInstance(componentType, values.size()));
}