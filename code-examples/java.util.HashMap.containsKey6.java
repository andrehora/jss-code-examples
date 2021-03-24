public static EcrfFieldValueAuditTrailLogEagerModel getCachedAuditTrailLogModel(ProbandListEntryOutVO listEntry,
		HashMap<Long, EcrfFieldValueAuditTrailLogEagerModel> auditTrailLogModelCache) {
	EcrfFieldValueAuditTrailLogEagerModel model;
	if (listEntry != null && auditTrailLogModelCache != null) {
		long listEntryId = listEntry.getId();
		if (auditTrailLogModelCache.containsKey(listEntryId)) {
			model = auditTrailLogModelCache.get(listEntryId);
		} else {
			model = new EcrfFieldValueAuditTrailLogEagerModel();
			model.setListEntryId(listEntryId);
			auditTrailLogModelCache.put(listEntryId, model);
		}
	} else {
		model = new EcrfFieldValueAuditTrailLogEagerModel();
	}
	return model;
}