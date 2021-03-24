public static Set<SingleInstance> loadData(File file)
        throws IOException
{
    Set<SingleInstance> result = new HashSet<>();

    List<String> lines = IOUtils
            .readLines(new InputStreamReader(new FileInputStream(file), "utf-8"));

    for (String line : lines) {
        if (!line.startsWith("#")) {
            result.add(new SingleInstance(line));
        }
    }

    // make sure there are all instances (minus one for the comment line)
    if (result.size() != (lines.size() - 1)) {
        throw new IllegalStateException("Inconsistent input");
    }

    return result;
}