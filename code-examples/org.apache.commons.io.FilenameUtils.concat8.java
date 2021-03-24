public static DataSetIterator getDataSetIterator(String DATA_PATH, boolean isTraining, WordVectors wordVectors, int minibatchSize,
                                                  int maxSentenceLength, Random rng ){
    String path = FilenameUtils.concat(DATA_PATH, (isTraining ? "aclImdb/train/" : "aclImdb/test/"));
    String positiveBaseDir = FilenameUtils.concat(path, "pos");
    String negativeBaseDir = FilenameUtils.concat(path, "neg");

    File filePositive = new File(positiveBaseDir);
    File fileNegative = new File(negativeBaseDir);

    Map<String,List<File>> reviewFilesMap = new HashMap<>();
    reviewFilesMap.put("Positive", Arrays.asList(filePositive.listFiles()));
    reviewFilesMap.put("Negative", Arrays.asList(fileNegative.listFiles()));

    LabeledSentenceProvider sentenceProvider = new FileLabeledSentenceProvider(reviewFilesMap, rng);

    return new CnnSentenceDataSetIterator.Builder()
            .sentenceProvider(sentenceProvider)
            .wordVectors(wordVectors)
            .minibatchSize(minibatchSize)
            .maxSentenceLength(maxSentenceLength)
            .useNormalizedWordVectors(false)
            .build();
}