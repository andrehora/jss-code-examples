public class JavaFileDirectoryExistsExample
{
  public static void main(String[] args)
  {
    // test "/var/tmp" directory
    File tmpDir = new File("/var/tmp");
    boolean exists = tmpDir.exists();
    if (exists) System.out.println("/var/tmp exists");
    
    if (tmpDir.isDirectory()) System.out.println("/var/tmp is a directory");

    // test to see if a file exists
    File file = new File("/Users/al/.bash_history");
    exists = file.exists();
    if (file.exists() && file.isFile())
    {
      System.out.println("file exists, and it is a file");
    }
  }
}