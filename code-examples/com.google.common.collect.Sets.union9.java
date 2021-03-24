public Set<E> adjacentEdges(E edge) {
  EndpointPair<N> endpointPair = incidentNodes(edge); // Verifies that edge is in this network.
  Set<E> endpointPairIncidentEdges =
      Sets.union(incidentEdges(endpointPair.nodeU()), incidentEdges(endpointPair.nodeV()));
  return Sets.difference(endpointPairIncidentEdges, ImmutableSet.of(edge));
}