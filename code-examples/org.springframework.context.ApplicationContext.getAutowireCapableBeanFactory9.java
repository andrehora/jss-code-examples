public void injectionUsingConstrettoWithEnvironmentSetAndUsinginterface(){
class MyConsumer {
    @Autowired CommonInterface commonInterface;
  }
  setProperty(ASSEMBLY_KEY,"stub");
  ApplicationContext ctx=loadContextAndInjectWithConstretto();
  MyConsumer consumer=new MyConsumer();
  ctx.getAutowireCapableBeanFactory().autowireBean(consumer);
  Assert.assertEquals(consumer.commonInterface.getClass(),CommonInterfaceStub.class);
}