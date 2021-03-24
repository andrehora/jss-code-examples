public SmallObjectHeap(final String p_memDumpFile, final Storage p_memory) {
    m_memory = p_memory;

    File file = new File(p_memDumpFile);

    if (!file.exists()) {
        throw new MemoryRuntimeException("Cannot create heap from mem dump " + p_memDumpFile + ": file does not exist");
    }

    RandomAccessFileImExporter importer;
    try {
        importer = new RandomAccessFileImExporter(file);
    } catch (final FileNotFoundException e) {
        // cannot happen
        throw new MemoryRuntimeException("Illegal state", e);
    }

    importer.importObject(this);
}