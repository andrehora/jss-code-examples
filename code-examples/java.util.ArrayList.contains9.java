public static ArrayList<IMarker> getSumSources(IMarker iMarker) {
  iMarker = MarkUtilities.getLeaderOfMarker(iMarker);

  final Map<IMarker, String> sourcesMap = AlloyUtilities.getRelationsOfSecondSideMarker(iMarker);
  final ArrayList<IMarker> sourcesList = AlloyUtilities.getSourcesOfMarkerAtRelations(iMarker);

  final ArrayList<IMarker> resultList = new ArrayList<>(sourcesList);

  final Set<IMarker> sourceMarkers = sourcesMap.keySet();
  final Iterator<IMarker> iter = sourceMarkers.iterator();
  while (iter.hasNext()) {
    final IMarker iMarkerSet = iter.next();
    if (!sourcesList.contains(iMarkerSet)) {
      resultList.add(iMarkerSet);
    }
  }
  return resultList;
}