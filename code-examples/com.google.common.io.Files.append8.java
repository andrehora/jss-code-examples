private void saveDataToFile(LoadData data, String dnName) {
    if (data.getFileName() == null) {
        String dnPath = tempPath + dnName + ".txt";
        data.setFileName(dnPath);
    }

    File dnFile = new File(data.getFileName());
    try {
        if (!dnFile.exists()) {
            Files.createParentDirs(dnFile);
        }
        Files.append(joinLine(data.getData(), data), dnFile, Charset.forName(loadData.getCharset()));

    } catch (IOException e) {
        throw new RuntimeException(e);
    } finally {
        data.setData(null);
    }
}