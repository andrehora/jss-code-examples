private void mergeChildrenWithMultipleDeclarations(
        XmlElement lowerPriorityChild,
        MergingReport.Builder mergingReport) {

    Preconditions.checkArgument(lowerPriorityChild.getType().areMultipleDeclarationAllowed());
    if (lowerPriorityChild.getType().areMultipleDeclarationAllowed()) {
        for (XmlElement sameTypeChild : getAllNodesByType(lowerPriorityChild.getType())) {
            if (sameTypeChild.getId().equals(lowerPriorityChild.getId()) &&
                    sameTypeChild.isEquals(lowerPriorityChild)) {
                return;
            }
        }
    }
    // if we end up here, we never found a child of this element with the same key and strictly
    // equals to the lowerPriorityChild so we should merge it in.
    addElement(lowerPriorityChild, mergingReport);
}