protected static Object getScopeService(IScope scope,String name,Class<?> defaultClass){
  if (scope == null) {
    return null;
  }
  final IContext context=scope.getContext();
  ApplicationContext appCtx=context.getApplicationContext();
  Object result;
  if (!appCtx.containsBean(name)) {
    if (defaultClass == null) {
      return null;
    }
    try {
      result=defaultClass.newInstance();
    }
 catch (    Exception e) {
      log.error("{}",e);
      return null;
    }
  }
 else {
    result=appCtx.getBean(name);
  }
  return result;
}