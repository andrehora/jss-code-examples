public Set<Link> getLinks(ConnectPoint connectPoint) {
    checkPermission(LINK_READ);
    checkNotNull(connectPoint, CONNECT_POINT_NULL);
    return Sets.union(store.getEgressLinks(connectPoint),
                      store.getIngressLinks(connectPoint));
}