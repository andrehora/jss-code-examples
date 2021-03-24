public void testConcat() {
        assertEquals(null, FilenameUtils.concat("", null));
        assertEquals(null, FilenameUtils.concat(null, null));
        assertEquals(null, FilenameUtils.concat(null, ""));
        assertEquals(null, FilenameUtils.concat(null, "a"));
        assertEquals(SEP + "a", FilenameUtils.concat(null, "/a"));
        
        assertEquals(null, FilenameUtils.concat("", ":")); // invalid prefix
        assertEquals(null, FilenameUtils.concat(":", "")); // invalid prefix
        
        assertEquals("f" + SEP, FilenameUtils.concat("", "f/"));
        assertEquals("f", FilenameUtils.concat("", "f"));
        assertEquals("a" + SEP + "f" + SEP, FilenameUtils.concat("a/", "f/"));
        assertEquals("a" + SEP + "f", FilenameUtils.concat("a", "f"));
        assertEquals("a" + SEP + "b" + SEP + "f" + SEP, FilenameUtils.concat("a/b/", "f/"));
        assertEquals("a" + SEP + "b" + SEP + "f", FilenameUtils.concat("a/b", "f"));
        
        assertEquals("a" + SEP + "f" + SEP, FilenameUtils.concat("a/b/", "../f/"));
        assertEquals("a" + SEP + "f", FilenameUtils.concat("a/b", "../f"));
        assertEquals("a" + SEP + "c" + SEP + "g" + SEP, FilenameUtils.concat("a/b/../c/", "f/../g/"));
        assertEquals("a" + SEP + "c" + SEP + "g", FilenameUtils.concat("a/b/../c", "f/../g"));
        
        assertEquals("a" + SEP + "c.txt" + SEP + "f", FilenameUtils.concat("a/c.txt", "f"));
        
        assertEquals(SEP + "f" + SEP, FilenameUtils.concat("", "/f/"));
        assertEquals(SEP + "f", FilenameUtils.concat("", "/f"));
        assertEquals(SEP + "f" + SEP, FilenameUtils.concat("a/", "/f/"));
        assertEquals(SEP + "f", FilenameUtils.concat("a", "/f"));
        
        assertEquals(SEP + "c" + SEP + "d", FilenameUtils.concat("a/b/", "/c/d"));
        assertEquals("C:c" + SEP + "d", FilenameUtils.concat("a/b/", "C:c/d"));
        assertEquals("C:" + SEP + "c" + SEP + "d", FilenameUtils.concat("a/b/", "C:/c/d"));
        assertEquals("~" + SEP + "c" + SEP + "d", FilenameUtils.concat("a/b/", "~/c/d"));
        assertEquals("~user" + SEP + "c" + SEP + "d", FilenameUtils.concat("a/b/", "~user/c/d"));
        assertEquals("~" + SEP, FilenameUtils.concat("a/b/", "~"));
        assertEquals("~user" + SEP, FilenameUtils.concat("a/b/", "~user"));
}