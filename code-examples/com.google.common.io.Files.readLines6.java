public void dumpsStepsReplacingAliases() throws IOException {
    Map<String, String> firstStep = new HashMap<>();
    firstStep.put(EVENT, loadPageActionName);
    firstStep.put(aliasUrl, aliasUrlValue);

    Map<String, String> secondStep = new HashMap<>();
    secondStep.put(EVENT, typeInNameInputActionName);
    secondStep.put(aliasText, aliasTextValue);

    TestScenarioSteps testScenarioSteps = new TestScenarioSteps();
    testScenarioSteps.add(firstStep);
    testScenarioSteps.add(secondStep);


    Map<String, ApplicationActionConfiguration> actionConfigurationMap = createAliasesMockConfiguration();

    StepsDumper stepsDumper = new DslStepsDumper(actionConfigurationMap);
    stepsDumper.dump(testScenarioSteps, outputFilename);

    List<String> lines = Files.readLines(outputFile, Charsets.UTF_8);
    assertEquals(2, lines.size());
    assertEquals("loadPage: Load text-field.html page ", lines.get(0));
    assertEquals("typeInNameInput: Type admin in name input ", lines.get(1));
}