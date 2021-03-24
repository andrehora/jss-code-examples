public void readFromFile() throws IOException
{
    Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
    try
    {
        in.useDelimiter(",");
        headerLine = in.nextLine(); // Skip header row
        while (in.hasNextLine())
        {
            String srgName = in.next();
            String mcpName = in.next();
            String side = in.nextLine().substring(1);
            srgParamName2ParamCsvData.put(srgName, new ParamCsvData(srgName, mcpName, Integer.valueOf(side)));
        }
    }
    finally
    {
        in.close();
    }
}