private void updateAndDeleteCache() {
  List<Long> ids = Lists.newArrayList(appNamespaceIdCache.keySet());
  if (CollectionUtils.isEmpty(ids)) {
    return;
  }
  List<List<Long>> partitionIds = Lists.partition(ids, 500);
  for (List<Long> toRebuild : partitionIds) {
    Iterable<AppNamespace> appNamespaces = appNamespaceRepository.findAll(toRebuild);

    if (appNamespaces == null) {
      continue;
    }

    //handle updated
    Set<Long> foundIds = handleUpdatedAppNamespaces(appNamespaces);

    //handle deleted
    handleDeletedAppNamespaces(Sets.difference(Sets.newHashSet(toRebuild), foundIds));
  }
}