public void testBootstrapAndShutdown() throws Exception
{
    // now bring up the bootstrap
    ApplicationContext ctx = new ClassPathXmlApplicationContext(APP_CONTEXT_XML);
    
    // the folder should be gone
    assertFalse("Folder was not deleted by bootstrap", dir.exists());
    
    // now create the folder again
    dir.mkdir();
    assertTrue("Directory not created", dir.exists());
    
    // announce that the context is closing
    ctx.publishEvent(new ContextClosedEvent(ctx));
    
    // the folder should be gone
    assertFalse("Folder was not deleted by shutdown", dir.exists());
}