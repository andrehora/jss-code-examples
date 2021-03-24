public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = 
               new ClassPathXmlApplicationContext("spring-beans.xml");
        System.out.println("Application context has been started - publishing message");
        
        CustomMsgEvent customMsgEvent = new CustomMsgEvent(applicationContext, 
                    "Test message");
        applicationContext.publishEvent(customMsgEvent); 
        //-blocking call i.e. synchronous        
        System.out.println("The custom event was published successfully");
        
        System.out.println("Starting the applicationContext");
        ((ConfigurableApplicationContext)applicationContext).start();
        
        System.out.println("Stopping the applicationContext");
        ((ConfigurableApplicationContext)applicationContext).stop();
    }
}