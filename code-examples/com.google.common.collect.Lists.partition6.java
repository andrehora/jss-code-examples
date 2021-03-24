public int reindex(List<K> keys, int batchSize, ReindexOperation<E> reindexOperation) {
    int count = 0;
    List<List<K>> batches = Lists.partition(keys, batchSize);
    for (List<K> batchKeys : batches) {
        List<E> batch = get(batchKeys);
        batch = reindexOperation == null ? batch : reindexOperation.apply(batch);
        if (reindexOperation != null) {
            // we only re-save the batch when a re-index op is supplied, otherwise the data can't have changed.
            ofy().save().entities(batch).now();
        }
        if (shouldSearch()) {
            index(batch).complete();
        }
        count += batch.size();
        ofy().clear(); // Clear the Objectify cache to free memory for next batch
        Logger.info("Reindexed %d entities of type %s, %d of %d", batch.size(), entityType.getSimpleName(), count, keys.size());
    }
    return count;
}