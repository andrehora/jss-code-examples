public static void registerAllIPCams(String fname)
{
	File f = new File(fname);
	if(f.exists()&&f.isFile())
	{
		try {
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine())
			{
				registerIPCam(scan.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e) {
		}
	}
}