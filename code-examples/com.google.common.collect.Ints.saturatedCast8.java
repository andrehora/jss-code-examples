public Set<EndpointPair<N>> edges() {
  return new AbstractSet<EndpointPair<N>>() {
    @Override
    public UnmodifiableIterator<EndpointPair<N>> iterator() {
      return EndpointPairIterator.of(AbstractBaseGraph.this);
    }

    @Override
    public int size() {
      return Ints.saturatedCast(edgeCount());
    }

    @Override
    public boolean contains(@Nullable Object obj) {
      if (!(obj instanceof EndpointPair)) {
        return false;
      }
      EndpointPair<?> endpointPair = (EndpointPair<?>) obj;
      return isDirected() == endpointPair.isOrdered()
          && nodes().contains(endpointPair.nodeU())
          && successors(endpointPair.nodeU()).contains(endpointPair.nodeV());
    }
  };
}