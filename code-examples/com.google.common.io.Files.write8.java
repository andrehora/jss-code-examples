public void testLifecycle() throws IOException, InterruptedException {
  File f1 = new File(tmpDir, "file1");
  Files.write("file1line1\nfile1line2\n", f1, Charsets.UTF_8);

  Context context = new Context();
  context.put(POSITION_FILE, posFilePath);
  context.put(FILE_GROUPS, "f1");
  context.put(FILE_GROUPS_PREFIX + "f1", tmpDir.getAbsolutePath() + "/file1$");
  Configurables.configure(source, context);

  for (int i = 0; i < 3; i++) {
    source.start();
    source.process();
    assertTrue("Reached start or error", LifecycleController.waitForOneOf(
        source, LifecycleState.START_OR_ERROR));
    assertEquals("Server is started", LifecycleState.START,
        source.getLifecycleState());

    source.stop();
    assertTrue("Reached stop or error",
        LifecycleController.waitForOneOf(source, LifecycleState.STOP_OR_ERROR));
    assertEquals("Server is stopped", LifecycleState.STOP,
        source.getLifecycleState());
  }
}