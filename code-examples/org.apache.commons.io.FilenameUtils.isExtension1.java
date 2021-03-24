public void testIsExtension() {
        assertEquals(false, FilenameUtils.isExtension(null, (String) null));
        assertEquals(false, FilenameUtils.isExtension("file.txt", (String) null));
        assertEquals(true, FilenameUtils.isExtension("file", (String) null));
        assertEquals(false, FilenameUtils.isExtension("file.txt", ""));
        assertEquals(true, FilenameUtils.isExtension("file", ""));
        assertEquals(true, FilenameUtils.isExtension("file.txt", "txt"));
        assertEquals(false, FilenameUtils.isExtension("file.txt", "rtf"));
        
        assertEquals(false, FilenameUtils.isExtension("a/b/file.txt", (String) null));
        assertEquals(false, FilenameUtils.isExtension("a/b/file.txt", ""));
        assertEquals(true, FilenameUtils.isExtension("a/b/file.txt", "txt"));
        assertEquals(false, FilenameUtils.isExtension("a/b/file.txt", "rtf"));
        
        assertEquals(false, FilenameUtils.isExtension("a.b/file.txt", (String) null));
        assertEquals(false, FilenameUtils.isExtension("a.b/file.txt", ""));
        assertEquals(true, FilenameUtils.isExtension("a.b/file.txt", "txt"));
        assertEquals(false, FilenameUtils.isExtension("a.b/file.txt", "rtf"));
        
        assertEquals(false, FilenameUtils.isExtension("a\\b\\file.txt", (String) null));
        assertEquals(false, FilenameUtils.isExtension("a\\b\\file.txt", ""));
        assertEquals(true, FilenameUtils.isExtension("a\\b\\file.txt", "txt"));
        assertEquals(false, FilenameUtils.isExtension("a\\b\\file.txt", "rtf"));
        
        assertEquals(false, FilenameUtils.isExtension("a.b\\file.txt", (String) null));
        assertEquals(false, FilenameUtils.isExtension("a.b\\file.txt", ""));
        assertEquals(true, FilenameUtils.isExtension("a.b\\file.txt", "txt"));
        assertEquals(false, FilenameUtils.isExtension("a.b\\file.txt", "rtf"));
        
        assertEquals(false, FilenameUtils.isExtension("a.b\\file.txt", "TXT"));
}