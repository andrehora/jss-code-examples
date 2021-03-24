public AnswerKey copyFallingBackTo(AnswerKey fallback) {
  final Builder ret = modifiedCopyBuilder();

  final ImmutableMap<String, Response> unannotatedHere = Maps.uniqueIndex(unannotatedResponses(),
      ResponseFunctions.uniqueIdentifier());
  final ImmutableMap<String, AssessedResponse> idToAssessedHere =
      Maps.uniqueIndex(annotatedResponses(),
          Functions.compose(ResponseFunctions.uniqueIdentifier(),
              AssessedResponseFunctions.response()));
  final Set<String> idsHere = Sets.union(unannotatedHere.keySet(), idToAssessedHere.keySet());

  final ImmutableMap<String, Response> unannotatedThere = Maps.uniqueIndex(
      fallback.unannotatedResponses(), ResponseFunctions.uniqueIdentifier());
  final ImmutableMap<String, AssessedResponse> idToAssessedThere =
      Maps.uniqueIndex(fallback.annotatedResponses(),
          Functions.compose(ResponseFunctions.uniqueIdentifier(),
              AssessedResponseFunctions.response()));
  final Set<String> idsThere = Sets.union(unannotatedThere.keySet(), idToAssessedThere.keySet());

  final Set<String> idsOnlyInFallback = Sets.difference(idsThere, idsHere);
  for (final String id : idsOnlyInFallback) {
    if (unannotatedThere.containsKey(id)) {
      ret.addUnannotated(unannotatedThere.get(id));
    }
    if (idToAssessedThere.containsKey(id)) {
      final AssessedResponse r = idToAssessedThere.get(id);
      final int CASGroup;
      if (corefAnnotation().CASesToIDs().containsKey(r.response().canonicalArgument())) {
        CASGroup = corefAnnotation().CASesToIDs().get(r.response().canonicalArgument());
      } else {
        CASGroup = fallback.corefAnnotation().CASesToIDs().get(r.response().canonicalArgument());
      }
      ret.addAnnotated(r, CASGroup);
    }
  }
  return ret.build();
}