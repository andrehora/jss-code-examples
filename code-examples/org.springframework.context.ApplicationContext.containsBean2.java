public class MyClass implements ApplicationContextAware {
 
    static final long serialVersionUID = 02L;
 
    ApplicationContext applicationContext = null;
 
    public void doSomething(){
        if (applicationContext != null && applicationContext.containsBean("accessKeys")){
            MyBean beanA = (MyBean) applicationContext.getBean("mybean");
            //Do something with this AccessBean
        }
 
        return null;
    }
 
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        System.out.println("setting context");
        this.applicationContext = applicationContext;
    }
 
}