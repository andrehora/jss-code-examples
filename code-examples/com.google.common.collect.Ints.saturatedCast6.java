public ApacheThriftMethodInvoker(
        ListeningExecutorService executorService,
        ListeningScheduledExecutorService delayService,
        TTransportFactory transportFactory,
        TProtocolFactory protocolFactory,
        Duration connectTimeout,
        Duration requestTimeout,
        Optional<HostAndPort> socksProxy,
        Optional<SSLContext> sslContext)
{
    this.executorService = requireNonNull(executorService, "executorService is null");
    this.delayService = requireNonNull(delayService, "delayService is null");
    this.transportFactory = requireNonNull(transportFactory, "transportFactory is null");
    this.protocolFactory = requireNonNull(protocolFactory, "protocolFactory is null");
    this.connectTimeoutMillis = Ints.saturatedCast(requireNonNull(connectTimeout, "connectTimeout is null").toMillis());
    this.requestTimeoutMillis = Ints.saturatedCast(requireNonNull(requestTimeout, "requestTimeout is null").toMillis());
    this.socksProxy = requireNonNull(socksProxy, "socksProxy is null");
    this.sslContext = requireNonNull(sslContext, "sslContext is null");
}