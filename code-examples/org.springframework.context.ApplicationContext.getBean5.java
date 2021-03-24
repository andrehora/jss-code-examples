public class MySingletonBean {

    @Autowired
    private ApplicationContext applicationContext;

    public void showMessage(){
        MyPrototypeBean bean = applicationContext.getBean(MyPrototypeBean.class);
        System.out.println("Hi, the time is "+bean.getDateTime());
    }
}