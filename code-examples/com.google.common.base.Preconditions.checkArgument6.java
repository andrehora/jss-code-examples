public <T> Class<? extends T> getClass(String path, Class<T> iface, Class<? extends T> defaultImpl) {
  if (this.hasPath(path)) {
    String className = this.getString(path);
    ;
    try {
      Class<?> clazz = Class.forName(className);
      Preconditions.checkArgument(iface.isAssignableFrom(clazz));
      return (Class<? extends T>) clazz;
    } catch (ClassNotFoundException e) {
      throw UserException.unsupportedError(e)
      .message("Failure while attempting to find implementation class %s for interface  %s. The sabot config key is %s ",
          defaultImpl.getName(), iface.getName(), path).build(logger);
    }
  }

  return defaultImpl;
}