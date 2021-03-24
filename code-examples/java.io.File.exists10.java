public synchronized static boolean setOfflineFilePath( String newPath )
{
	if ( !newPath.endsWith( "/" ) )
	{
		newPath = newPath + "/";
	}

	File newTarget = new File( newPath );

	if ( !newTarget.exists() || !newTarget.isDirectory() )
	{
		return false;
	}

	OFFLINE_FILE_PATH = newPath;

	return true;
}