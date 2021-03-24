protected synchronized void releaseResource(Resource clusterResource,
    Resource resource, Set<String> nodeLabels) {
  // Update usedResources by labels
  if (null == nodeLabels || nodeLabels.isEmpty()) {
    queueUsage.decUsed(resource);
  } else {
    Set<String> anls = (accessibleLabels.contains(RMNodeLabelsManager.ANY))
        ? labelManager.getClusterNodeLabels() : accessibleLabels;
    for (String label : Sets.intersection(anls, nodeLabels)) {
      queueUsage.decUsed(label, resource);
    }
  }

  if (null == nodeLabels || nodeLabels.isEmpty()) {
    CSQueueUtils.updateQueueStatistics(resourceCalculator, this, getParent(),
        labelManager.getResourceByLabel(RMNodeLabelsManager.NO_LABEL, clusterResource), minimumAllocation);
  }
  --numContainers;
}