private void doTestUnpackWAR(boolean unpackWARs, boolean unpackWAR,
        boolean external, boolean resultDir) throws Exception {

    Tomcat tomcat = getTomcatInstance();
    StandardHost host = (StandardHost) tomcat.getHost();

    host.setUnpackWARs(unpackWARs);

    tomcat.start();

    File war;
    if (unpackWAR) {
        war = createWar(WAR_XML_UNPACKWAR_TRUE_SOURCE, !external);
    } else {
        war = createWar(WAR_XML_UNPACKWAR_FALSE_SOURCE, !external);
    }
    if (external) {
        createXmlInConfigBaseForExternal(war);
    }

    host.backgroundProcess();

    File dir = new File(host.getAppBase(), APP_NAME.getBaseName());
    Assert.assertEquals(
            Boolean.valueOf(resultDir), Boolean.valueOf(dir.isDirectory()));
}