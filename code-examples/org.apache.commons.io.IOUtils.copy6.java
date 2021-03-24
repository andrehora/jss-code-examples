public void setUp() throws Exception {
  // resource file
  this.jsonResource = "org/apache/geode/security/templates/security.json";
  InputStream inputStream = ClassLoader.getSystemResourceAsStream(this.jsonResource);

  assertThat(inputStream).isNotNull();

  // non-resource file
  this.jsonFile = new File(temporaryFolder.getRoot(), "security.json");
  IOUtils.copy(inputStream, new FileOutputStream(this.jsonFile));

  // string
  this.json = FileUtils.readFileToString(this.jsonFile, "UTF-8");
  this.exampleSecurityManager = new ExampleSecurityManager();
}