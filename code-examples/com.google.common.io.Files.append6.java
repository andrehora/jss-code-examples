public void testFileChangesDuringRead() throws IOException {
  File f1 = new File(tmpDir.getAbsolutePath() + "/file1");

  Files.write("file1line1\nfile1line2\n", f1, Charsets.UTF_8);

  ReliableSpoolingFileEventReader parser1 = getParser();

  List<String> out = Lists.newArrayList();
  out.addAll(bodiesAsStrings(parser1.readEvents(2)));
  parser1.commit();

  assertEquals(2, out.size());
  assertTrue(out.contains("file1line1"));
  assertTrue(out.contains("file1line2"));

  Files.append("file1line3\n", f1, Charsets.UTF_8);

  out.add(bodyAsString(parser1.readEvent()));
  parser1.commit();
  out.add(bodyAsString(parser1.readEvent()));
  parser1.commit();
}