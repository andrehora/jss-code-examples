public SwitchRepresentation(@Nonnull IOFSwitch sw, @Nonnull OFSwitchHandshakeHandler handshakeHandler) {
    Preconditions.checkNotNull(sw, "switch must not be null");
    Preconditions.checkNotNull(handshakeHandler, "handshakeHandler must not be null");

    // IOFSwitch
    this.buffers = sw.getBuffers();
    this.capabilities = sw.getCapabilities();
    this.tables = sw.getNumTables();
    this.inetAddress = sw.getInetAddress();
    this.sortedPorts = sw.getSortedPorts();
    this.isConnected = sw.isConnected();
    this.connectedSince = sw.getConnectedSince();
    this.dpid = sw.getId();
    this.attributes = sw.getAttributes();
    this.isActive = sw.isActive();

    // OFSwitchHandshakeHandler
    this.connections = handshakeHandler.getConnections();
    this.handshakeState = handshakeHandler.getState();
    this.quarantineReason = handshakeHandler.getQuarantineReason();
}