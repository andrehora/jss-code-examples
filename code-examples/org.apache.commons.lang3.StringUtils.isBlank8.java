public static Map<String, Map<String, Object>> getUpdateYamlScript(final ScriptClass scriptClass) {
    final Updater updater = scriptClass.getUpdater();

    Map<String, Object> properties = new LinkedHashMap<>();
    addNotEmptyProperty(JCR_PRIMARY_TYPE, HIPPOSYS_UPDATERINFO, properties);

    addNotEmptyProperty(HIPPOSYS_BATCHSIZE, updater.batchSize(), properties);
    addNotEmptyProperty(HIPPOSYS_DESCRIPTION, updater.description(), properties);
    addNotEmptyProperty(HIPPOSYS_DRYRUN, updater.dryRun(), properties);
    addNotEmptyProperty(HIPPOSYS_PARAMETERS, updater.parameters(), properties);
    if (StringUtils.isBlank(updater.xpath())) {
        addNotEmptyProperty(HIPPOSYS_PATH, updater.path(), properties);
    }
    addNotEmptyProperty(HIPPOSYS_QUERY, updater.xpath(), properties);
    addNotEmptyProperty(HIPPOSYS_SCRIPT, removeEmptyIndents(scriptClass.getContent()), properties);
    addNotEmptyProperty(HIPPOSYS_THROTTLE, updater.throttle(), properties);
    return Collections.singletonMap(getBootstrapPath(scriptClass), properties);
}