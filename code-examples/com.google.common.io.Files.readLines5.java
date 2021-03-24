public void readFileWithGuava (String fileName)
{
    try
    {
        File file = new File( fileName );
        List lines = Files.readLines(file, "UTF-8");
        for (String line : lines) {
            System.out.println( line );
        }
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
}