static List<String> readFile(File inFile, Map<String, String[]> read) throws IOException
{
    List<String> list = Files.readLines(inFile, Charsets.UTF_8);

    for (String s : list)
    {
        s = s.trim();

        if (!s.startsWith("#") && s.length() >= 1)
        {
            String[] astring = s.split("\\|");
            read.put(astring[0].toLowerCase(Locale.ROOT), astring);
        }
    }

    return list;
}