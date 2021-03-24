private BrokerService createBrokerService(final String name) {
    final BrokerService broker = new BrokerService();
    broker.setPersistent(persistent);
    broker.setBrokerName(name);
    broker.setStartAsync(false);
    tempDir = Files.createTempDir();
    broker.setDataDirectoryFile(tempDir);
    try {
        broker.addConnector(createVmTransportServer(createVmTransportUri(name)));
    } catch (Exception e) {
        throw new IllegalStateException("Could not create VM Transport URI", e);
    }
    broker.setUseJmx(false);

    return broker;
}