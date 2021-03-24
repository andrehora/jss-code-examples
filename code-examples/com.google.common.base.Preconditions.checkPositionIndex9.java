public TimeSeriesPoint getPoint(int index) {
    Preconditions.checkPositionIndex(index, points.size());
    return points.get(index);
}