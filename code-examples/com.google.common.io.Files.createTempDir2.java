public void demoTemporaryDirectoryCreation()
{
	final File newTempDir = Files.createTempDir();
	try
	{
		out.println(
				"New temporary directory is '" + newTempDir.getCanonicalPath() + "'.");
	}
	catch (IOException ioEx)
	{
		err.println("ERROR: Unable to create temporary directory - " + ioEx.toString());
	}
}