private GrpcEngine getGrpcEngine(String registryAddress, int registryPort) {
    String key = registryAddress + ":" + registryPort;
    LOCK.lock();
    try {
        GrpcEngine engine = ENGINES.get(key);
        if (engine != null) {
            return engine;
        }
        Preconditions.checkNotNull(registryAddress, "registryAddress  is not Null", registryAddress);
        Preconditions.checkState(registryPort != 0, "RegistryPort can not be zero", registryPort);
        GrpcURL registryUrl = new GrpcURL(Constants.REGISTRY_PROTOCOL, registryAddress, registryPort);
        engine = new GrpcEngine(registryUrl);
        ENGINES.put(key, engine);
        return engine;
    } finally {
        LOCK.unlock();
    }
}