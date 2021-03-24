private static void fileCopyUsingApacheCommons() throws IOException
{
    File fileToCopy = new File("c:/temp/testoriginal.txt");
    File newFile = new File("c:/temp/testcopied.txt");
 
    FileUtils.copyFile(fileToCopy, newFile);
 
    // OR
 
    IOUtils.copy(new FileInputStream(fileToCopy), new FileOutputStream(newFile));
}