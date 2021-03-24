public static void main(String[] args) throws Exception {
  if (args.length != 1) {
    System.out.println("java " + PluginLoader.class.getName() + " <plugin-dir>");
    System.exit(1);
  }
  ApplicationContext context=new ClassPathXmlApplicationContext("classpath:META-INF/00_system.xml");
  PluginLoader pl=new PluginLoader(args[0]);
  ClassLoader cl=pl.loadPlugins();
  PluggableTaskFlowProvider provider=(PluggableTaskFlowProvider)context.getAutowireCapableBeanFactory().getBean("taskFlowProvider");
  provider.setCl(cl);
  provider.loadPlugins();
  provider.listPlugins();
  System.exit(0);
}