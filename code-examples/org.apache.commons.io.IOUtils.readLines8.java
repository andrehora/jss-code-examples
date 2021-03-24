private void loadLocaleData(InputStream inputStreamIn) throws IOException
{
    for (String s : IOUtils.readLines(inputStreamIn, Charsets.UTF_8))
    {
        if (!s.isEmpty() && s.charAt(0) != 35)
        {
            String[] astring = (String[])Iterables.toArray(SPLITTER.split(s), String.class);

            if (astring != null && astring.length == 2)
            {
                String s1 = astring[0];
                String s2 = PATTERN.matcher(astring[1]).replaceAll("%$1s");
                this.properties.put(s1, s2);
            }
        }
    }
}