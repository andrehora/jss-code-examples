protected List<File> findJarFile(String scriptLibDir) {
	List<File> files = new ArrayList<File>();
	try {
		File file = new File(scriptLibDir);
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				if (f.isFile() && f.getName().endsWith(".jar")) {
					files.add(f);
				}
			}
		}
	} catch (Exception e) {
		_log.error(e.getMessage(), e);
	}
	return files;
}