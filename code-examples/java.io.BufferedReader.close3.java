public class BufferedReaderExample
{
    public static void main(String[] args)
    {
        BufferedReader bufferedReader = null;
 
        try
        {
 
            String currLine;
 
            bufferedReader = new BufferedReader(new FileReader("C:\\temp\\testOut.txt"));
 
            while ((currLine = bufferedReader.readLine()) != null)
            {
                System.out.println(currLine);
            }
 
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                    bufferedReader.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}