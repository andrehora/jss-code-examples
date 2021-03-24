public void mergeHeaders() throws Exception {
  File output = new File(".test-files/mergeHeaders/merged-manifest.yml");
  File zip = new File(".test-files/mergeHeaders/headers.zip");
  zip.getParentFile().mkdirs();
  Files.write("xyz", zip, StandardCharsets.UTF_8);
  output.delete();
  String text = main("merge", "headers",
      "com.github.jomof:sqlite:3.16.2-rev48",
      zip.toString(),
      "include",
      output.toString());
  assertThat(text).doesNotContain("Usage");
  assertThat(text).contains("Merged com.github.jomof:sqlite:3.16.2-rev48 and ");
  System.out.printf(text);
  System.out.printf(FileUtils.readAllText(output));
}