private void setUpDirectories(PluginFileAccess access) throws IOException {
    access.createDirectories(UTIL_DIR_PATH);

    //Iterate over all files in the script list
    List<String> files = IOUtils.readLines(
        getClass().getResourceAsStream(RESOURCE_PATH_BASE + "scripts-list"),
        Charsets.UTF_8
    );
    for (String line : files) {
        if (!line.isEmpty()) {
            //Copy the file into the desired directory
            InputStreamReader input = new InputStreamReader(
                getClass().getResourceAsStream(RESOURCE_PATH_BASE + line)
            );
            BufferedWriter output = access.access(UTIL_DIR_PATH + line);
            IOUtils.copy(input, output);
            input.close();
            output.close();
        }
    }
}