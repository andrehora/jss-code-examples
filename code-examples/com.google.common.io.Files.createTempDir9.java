public void setUp() {
	javac = ToolProvider.getSystemJavaCompiler();
	diagnosticCollector = new DiagnosticCollector<>();
	fileManager = javac.getStandardFileManager(diagnosticCollector, null, null);
	tmpDir = Files.createTempDir();
}