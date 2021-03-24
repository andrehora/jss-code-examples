public void setup() throws Exception {
  baseDir = Files.createTempDir();
  keyStorePasswordFile = new File(baseDir, "keyStorePasswordFile");
  Files.write("keyStorePassword", keyStorePasswordFile, Charsets.UTF_8);
  keyAliasPassword = Maps.newHashMap();
  keyStoreFile = new File(baseDir, "keyStoreFile");
  Assert.assertTrue(keyStoreFile.createNewFile());
}