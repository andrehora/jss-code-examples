private List<Color> computeEdgeColors(final Edge edge) {
    final List<Color> edgeColors;

    if (edge.getFromSegment().equals(hoveredSegmentProperty.get())
            || edge.getToSegment().equals(hoveredSegmentProperty.get())) {
        edgeColors = Collections.singletonList(HighlightType.HIGHLIGHTED.getColor());
    } else if (edge.getGenomes() != null
            && graphDimensionsCalculator.getRadiusProperty().get() < MAX_PATH_THICKNESS_DRAWING_RADIUS) {
        final Set<String> selectedGenomesInEdge
                = Sets.intersection(edge.getGenomes(), selectedGenomePaths.keySet());

        if (selectedGenomesInEdge.isEmpty()) {
            edgeColors = Collections.singletonList(getEdgeColor());
        } else {
            edgeColors = selectedGenomesInEdge.stream()
                    .map(path -> correctColorForEdgeOpacity(selectedGenomePaths.get(path)))
                    .collect(Collectors.toList());
        }
    } else {
        edgeColors = Collections.singletonList(getEdgeColor());
    }

    return edgeColors;
}