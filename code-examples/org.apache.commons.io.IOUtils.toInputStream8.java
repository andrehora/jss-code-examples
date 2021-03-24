public void testGetVersion_WithMockedManifest_ReturnsValidVersion() throws IOException {
    //  Arrange.
    PowerMockito.mockStatic(VersionUtil.class);
    PowerMockito.when(VersionUtil.getVersion()).thenCallRealMethod();
    PowerMockito.when(VersionUtil.class.getPackage()).thenReturn(this.aPackage);
    PowerMockito.when(VersionUtil.class.getClassLoader()).thenReturn(this.classLoader);
    PowerMockito.when(this.classLoader.findResource(Matchers.anyString())).thenReturn(this.mockedUrl);
    InputStream stubInputStream = IOUtils.toInputStream(this.MANIFEST_CONTENT, Charset.defaultCharset());
    PowerMockito.when(this.mockedUrl.openStream()).thenReturn(stubInputStream);
    PowerMockito.when(this.aPackage.getImplementationVersion()).thenReturn("1.0.0");

    // Act.
    Version version = VersionUtil.getVersion();

    // Assert.
    Assert.assertTrue("11" == version.getBuild());
    Assert.assertEquals("1476885882", version.getBuildTime());
    Assert.assertTrue(1 == version.getMajor());
    Assert.assertTrue(2 == version.getMinor());
}