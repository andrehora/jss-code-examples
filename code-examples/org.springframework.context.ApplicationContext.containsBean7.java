public <T> T getExtension(Class<T> type, String name) {
    for (ApplicationContext context : contexts) {
        if (context.containsBean(name)) {
            Object bean = context.getBean(name);
            if (type.isInstance(bean)) {
                return (T) bean;
            }
        }
    }
    return null;
}