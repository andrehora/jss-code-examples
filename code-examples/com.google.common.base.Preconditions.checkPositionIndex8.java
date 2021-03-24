public float getDimension(int index) {
    Preconditions.checkPositionIndex(index, this.size());

    return dimensions[index];
}