public RowKey buildRowKey(StatEventKey statEventKey) {
    Preconditions.checkNotNull(statEventKey);

    long timeMs = statEventKey.getTimeMs();

    final byte[] partialTimestamp = buildPartialTimestamp(timeMs);
    final byte[] rollupBitMask = statEventKey.getRollupMask().asBytes();
    List<RowKeyTagValue> rowKeyTagValues = statEventKey.getTagValues().stream()
            .map(tagValue -> new RowKeyTagValue(tagValue.getTag(), tagValue.getValue()))
            .collect(Collectors.toList());

    TimeAgnosticRowKey timeAgnosticRowKey = new TimeAgnosticRowKey(
            statEventKey.getStatUuid(),
            rollupBitMask,
            rowKeyTagValues);

    //timeMs is already rounded to the column interval
    return new RowKey(timeAgnosticRowKey, partialTimestamp);
}