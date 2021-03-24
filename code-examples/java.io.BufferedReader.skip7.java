private void initConsistentReader() throws IOException {
    consistentReader = new BufferedReader(createReader());
    if (isSkipFirstLine && !this.offsets.isEmpty()) {
        consistentReader.skip(this.offsets.get(0)); //TODO: any other ideas how skip header?
    }
}