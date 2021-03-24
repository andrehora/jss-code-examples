public void SetResultFilePath(String mzXMLfile) {
	SpectrumPath = FilenameUtils.separatorsToUnix(FilenameUtils.getFullPath(mzXMLfile) + FilenameUtils.getName(mzXMLfile));
	PepXMLPath = FilenameUtils.separatorsToUnix(FilenameUtils.getFullPath(mzXMLfile) + FilenameUtils.getBaseName(mzXMLfile) + ".tandem.pep.xml");
	InteractPepXMLPath = FilenameUtils.separatorsToUnix(FilenameUtils.getFullPath(mzXMLfile) + "interact-" + FilenameUtils.getBaseName(mzXMLfile) + ".tandem.pep.xml");
	ProtXMLPath = InteractPepXMLPath.replace(".pep.xml", ".prot.xml");
	parameterPath = FilenameUtils.separatorsToUnix(FilenameUtils.getFullPath(mzXMLfile) + FilenameUtils.getBaseName(mzXMLfile) + ".tandem.param");
	RawSearchResult = FilenameUtils.separatorsToUnix(FilenameUtils.getFullPath(mzXMLfile) + FilenameUtils.getBaseName(mzXMLfile) + ".tandem");
}