public boolean needsPatching() {
	
	//Need to check if packages have changed.
	ArrayList<File> files = Ln.generateFileList(new File(AVFileVars.AVPackagesDir), false);
	try {
		ArrayList<String> last = AVFileVars.getAVPackagesListing();
		if (files.size() != last.size()) {
			if (SPGlobal.logging()) {
				SPGlobal.logMain(header, "Needs update because number of package files changed.");
			}
			return true;
		}

		for (File f : files) {
			String path = f.getPath();
			if (!last.contains(path)) {
				if (SPGlobal.logging()) {
					SPGlobal.logMain(header, "Needs update because last package list didn't contain: " + path);
				}
				return true;
			}
		}

	} catch (IOException ex) {
		SPGlobal.logException(ex);
		return true;
	}
	return false;
}