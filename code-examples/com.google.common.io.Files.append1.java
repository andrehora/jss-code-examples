public void append_to_file_guava () throws IOException {

    File file = new File(OUTPUT_FILE_NAME);

    Files.append("Append text to file w/ guava",
            file,
            Charsets.UTF_8);
}