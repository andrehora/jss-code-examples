public void testGetExtension() {
        assertEquals(null, FilenameUtils.getExtension(null));
        assertEquals("ext", FilenameUtils.getExtension("file.ext"));
        assertEquals("", FilenameUtils.getExtension("README"));
        assertEquals("com", FilenameUtils.getExtension("domain.dot.com"));
        assertEquals("jpeg", FilenameUtils.getExtension("image.jpeg"));
        assertEquals("", FilenameUtils.getExtension("a.b/c"));
        assertEquals("txt", FilenameUtils.getExtension("a.b/c.txt"));
        assertEquals("", FilenameUtils.getExtension("a/b/c"));
        assertEquals("", FilenameUtils.getExtension("a.b\\c"));
        assertEquals("txt", FilenameUtils.getExtension("a.b\\c.txt"));
        assertEquals("", FilenameUtils.getExtension("a\\b\\c"));
        assertEquals("", FilenameUtils.getExtension("C:\\temp\\foo.bar\\README"));
        assertEquals("ext", FilenameUtils.getExtension("../filename.ext"));
}