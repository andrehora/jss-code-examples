public static DictomatonDictionary loadDictionary(Set<String> whitelist) throws IOException, DictionaryBuilderException {
    CharSource source = getResource(WORD_FREQUENCIES_FILE);

    DictomatonDictionary dictomatonDictionary;
    BufferedReader reader = source.openBufferedStream();
    try {
        if (whitelist == null) {
            dictomatonDictionary = DictomatonDictionary.read(reader);
        } else {
            dictomatonDictionary = DictomatonDictionary.read(reader, whitelist);
        }
    } finally {
        reader.close();
    }
    return dictomatonDictionary;
}