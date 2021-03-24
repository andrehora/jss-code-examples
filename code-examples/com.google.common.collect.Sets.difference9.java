public void clusterChanged(ClusterChangedEvent event) {
    if (!event.metaDataChanged()) {
        return;
    }

    Set<String> newCurrentSchemas = getNewCurrentSchemas(event.state().metaData());
    synchronized (schemas) {
        Sets.SetView<String> nonBuiltInSchemas = Sets.difference(schemas.keySet(), builtInSchemas.keySet());
        Set<String> deleted = Sets.difference(nonBuiltInSchemas, newCurrentSchemas).immutableCopy();
        Set<String> added = Sets.difference(newCurrentSchemas, schemas.keySet()).immutableCopy();

        for (String deletedSchema : deleted) {
            try {
                schemas.remove(deletedSchema).close();
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        for (String addedSchema : added) {
            schemas.put(addedSchema, getCustomSchemaInfo(addedSchema));
        }
    }
}