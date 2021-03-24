public void validate(String s, String path) throws IOException {
    List<String> lines = IOUtils.readLines(
        getClass().getClassLoader().getResourceAsStream(path),
        "UTF-8"
    );
    List<String> lines2 = Arrays.asList(s.split("\n"));
    for (int i = 0; i < lines.size(); i++) {
        assertEquals(lines.get(i), lines2.get(i));
    }
}