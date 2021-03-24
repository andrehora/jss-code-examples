public void SetPepXMLPath() {
    iProphPepXMLs = new ArrayList<String>();
    String PepXMLPath1 = FilenameUtils.separatorsToUnix(FilenameUtils.getFullPath(Filename) + "interact-" + GetQ1Name() + ".pep.xml");
    String PepXMLPath2 = FilenameUtils.separatorsToUnix(FilenameUtils.getFullPath(Filename) + "interact-" + GetQ2Name() + ".pep.xml");
    String PepXMLPath3 = FilenameUtils.separatorsToUnix(FilenameUtils.getFullPath(Filename) + "interact-" + GetQ3Name() + ".pep.xml");
    iProphPepXMLs.add(PepXMLPath1);
    iProphPepXMLs.add(PepXMLPath2);
    iProphPepXMLs.add(PepXMLPath3);
}