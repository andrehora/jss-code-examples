public Aggregator createInternal(Aggregator parent, boolean collectsFromSingleBucket, List<PipelineAggregator> pipelineAggregators,
                                 Map<String, Object> metaData) throws IOException {
    HashMap<String, VS> valuesSources = new HashMap<>();

    for (Map.Entry<String, ValuesSourceConfig<VS>> config : configs.entrySet()) {
        VS vs = config.getValue().toValuesSource(context.getQueryShardContext());
        if (vs != null) {
            valuesSources.put(config.getKey(), vs);
        }
    }
    if (valuesSources.isEmpty()) {
        return createUnmapped(parent, pipelineAggregators, metaData);
    }
    return doCreateInternal(valuesSources, parent, collectsFromSingleBucket, pipelineAggregators, metaData);
}