public Collection<String> getEtr(){
	Collection<File> res = new LinkedList<File>();
	File[] listdir = new File(Engine.PROJECTS_PATH).listFiles();
	for(File s : listdir){
		File tracedir = new File(s,"Traces");
		if(tracedir.exists()&&tracedir.isDirectory()){
			File[] listconnectors = tracedir.listFiles();
			for(File s2 : listconnectors){
				res.addAll(Arrays.asList(s2.listFiles(new FilenameFilter(){
					public boolean accept(File arg0, String arg1) {
						return arg1.endsWith(".etr");
					}
				})));
			}
		}
	}
	Collection<String> listetr = new ArrayList<String>(res.size());
	for(File f : res)
		listetr.add(f.getPath().substring(Engine.PROJECTS_PATH.length()));
	return listetr;
}