private void parseRecords(InputStream stream) throws IOException {
    LineIterator it = IOUtils.lineIterator(buffer(stream), IabFile.CHARSET);
    while (it.hasNext()) {
        String record = StringUtils.trimToNull(it.nextLine());
        if (record != null) {
            if (isCidrNotation(record)) {
                cidrAddresses.add(subnetInfo(record));
            } else {
                plainAddresses.add(record);
            }
        }
    }
}