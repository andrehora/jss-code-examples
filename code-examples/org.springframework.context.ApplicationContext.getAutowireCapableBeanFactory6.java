@Override
public void init(FilterConfig filterConfig) throws ServletException {
    String module = getModule(filterConfig);
    ApplicationContext applicationContext = CloudStackSpringContext.getApplicationContext(filterConfig.getServletContext(), module);
    if (applicationContext != null) {
        AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
        if (factory != null) {
            factory.autowireBean(this);
            enabled = true;
        }
    }
}