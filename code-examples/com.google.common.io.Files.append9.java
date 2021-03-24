private void addToScenarioList(String testId, Set<String> templates, File scenarioList, ResultsStore resultsStore) {
    try {
        long estimatedRuntime = getEstimatedRuntime(testId, resultsStore);
        List<String> args = Lists.newArrayList();
        args.add(testId);
        args.add(String.valueOf(estimatedRuntime));
        args.addAll(templates);
        Files.touch(scenarioList);
        Files.append(Joiner.on(';').join(args) + '\n', scenarioList, Charsets.UTF_8);
    } catch (IOException e) {
        throw new RuntimeException("Could not write to scenario list at " + scenarioList, e);
    }
}