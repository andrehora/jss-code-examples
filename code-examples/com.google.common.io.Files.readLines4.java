public void count_lines_text_file_guava() throws IOException {

    long linesCounted = Files.readLines(
            Paths.get(fileLocation).toFile(), Charsets.UTF_8,
            new LineProcessor<Long>() {

                long numberOfLinesInTextFile = 0;

                @Override
                public boolean processLine(String line) throws IOException {

                    numberOfLinesInTextFile++;
                    return true;
                }

                @Override
                public Long getResult() {
                    return numberOfLinesInTextFile;
                }
            });

    assertEquals(10, linesCounted);
}