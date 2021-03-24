public void generateTargetFile(File fileOrDir) {
    File workingDir = fileOrDir.isDirectory() ? fileOrDir : fileOrDir.getParentFile();

    File templateFile = new File(workingDir,templateFileName);
    File targetFile = new File(workingDir, targetFileName);
    File valuesFile = new File(workingDir, valuesFileName);

    String[] contents = FileSupport.readContentOfFile(templateFile);

    Properties valueProperties = new Properties();
    try {
        valueProperties.load(new FileInputStream(valuesFile));
    } catch (IOException e) {
        throw new RuntimeException("Problem reading key value pairs from valuesFile " + valuesFile.getAbsolutePath());
    }
    for (String keyId: valueProperties.stringPropertyNames()) {
        String value = valueProperties.getProperty(keyId);
        TemplateKeyDefinition keyDefinition = getKeyDefinitionByKeyId(keyId);
        if (keyDefinition == null) continue;
        writeValueToContent(contents, keyDefinition, value);
    }

    FileSupport.writeContentOfFile(targetFile,contents);
}