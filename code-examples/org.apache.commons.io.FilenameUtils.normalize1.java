public void testNormalizeUnixWin() throws Exception {

        // Normalize (Unix Separator)
        assertEquals("/a/c/",    FilenameUtils.normalize("/a/b/../c/", true));
        assertEquals("/a/c/",    FilenameUtils.normalize("\\a\\b\\..\\c\\", true));

        // Normalize (Windows Separator)
        assertEquals("\\a\\c\\", FilenameUtils.normalize("/a/b/../c/", false));
        assertEquals("\\a\\c\\", FilenameUtils.normalize("\\a\\b\\..\\c\\", false));
}