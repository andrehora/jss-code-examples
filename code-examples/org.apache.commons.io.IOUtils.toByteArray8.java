public Map<String, String> getReproguardMapping(String jarPath) {
	Map<String, String> renameMap = new HashMap<>();
	try {
		JarFile file = new JarFile(new File(jarPath));
		Enumeration<JarEntry> enumeration = file.entries();
		while (enumeration.hasMoreElements()) {
			JarEntry jarEntry = enumeration.nextElement();
			InputStream inputStream = file.getInputStream(jarEntry);
			String entryName = jarEntry.getName();
			String className;
			byte[] sourceClassBytes = IOUtils.toByteArray(inputStream);
			if (entryName.endsWith(".class")) {
				className = Utils.path2Classname(entryName);
				String newClassname = getReproguardClassname(className);
				TextFileWritter.getDefaultWritter().println(className + (newClassname != null ? " -> " + newClassname : ""));
				//analyzeClassNames(className, sourceClassBytes);
			}
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	TextFileWritter.getDefaultWritter().close();
	return renameMap;
}