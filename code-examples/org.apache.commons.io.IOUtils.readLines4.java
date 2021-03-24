File file1;
File file2;
InputStream inputStream;
OutputStream outputStream;

// copy one file into another
FileUtils.copyFile(file1, file2);
IOUtils.copy(inputStream, outputStream);

// read a file into a String
String s1 = FileUtils.readFileToString(file1);
String s2 = IOUtils.toString(inputStream);

// read a file into a list of Strings, one item per line
List<String> l1 = FileUtils.readLines(file1);
List<String> l2 = IOUtils.readLines(inputStream);

// put this in your finally() clause after manipulating streams
IOUtils.closeQuietly(inputStream);

// return the list of xml and text files in the specified folder and any subfolders
Collection<File> c1 = FileUtils.listFiles(file1, { "xml", "txt" }, true);

// copy one folder and its contents into another
FileUtils.copyDirectoryToDirectory(file1, file2);

// delete one folder and its contents
FileUtils.deleteDirectory(file1);