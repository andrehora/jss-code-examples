public void execute(Tuple tuple) {
    File file = getFile();
    logger.debug("FILER: Writing tuple to disk: File = {}, tuple={}", file.getAbsolutePath(), tuple);

    try {
        // Start with just the values; determine later if the fields are needed.
        //Files.append(tuple.getFields().toString(), file, Charsets.UTF_8);
        Files.append(tuple.getValues().toString() + "\n", file, Charsets.UTF_8);
    } catch (IOException e) {
        logger.error("FILER: couldn't append to file: {}. Exception: {}. Cause: {}",
                file.getAbsolutePath(), e.getMessage(), e.getCause());
    }
    _collector.ack(tuple);
}