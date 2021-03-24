public static CollidingVisitScheduleItemEagerModel getCachedCollidingVisitScheduleItemModel(ProbandStatusEntryOutVO statusEntry, boolean allProbandGroups,
		HashMap<Long, CollidingVisitScheduleItemEagerModel> collidingVisitScheduleItemModelCache) {
	CollidingVisitScheduleItemEagerModel model;
	if (statusEntry != null && collidingVisitScheduleItemModelCache != null) {
		long probandStatusEntryId = statusEntry.getId();
		if (collidingVisitScheduleItemModelCache.containsKey(probandStatusEntryId)) {
			model = collidingVisitScheduleItemModelCache.get(probandStatusEntryId);
		} else {
			model = new CollidingVisitScheduleItemEagerModel(probandStatusEntryId, allProbandGroups);
			collidingVisitScheduleItemModelCache.put(probandStatusEntryId, model);
		}
	} else {
		model = new CollidingVisitScheduleItemEagerModel(allProbandGroups);
	}
	return model;
}