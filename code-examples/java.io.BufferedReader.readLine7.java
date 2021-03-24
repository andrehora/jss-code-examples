private void loadDefinition(String def, Color trans) throws SlickException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceLoader.getResourceAsStream(def)));

	try {
		image = new Image(basePath+reader.readLine(), false, filter, trans);
		while (reader.ready()) {
			if (reader.readLine() == null) {
				break;
			}
			
			Section sect = new Section(reader);
			sections.put(sect.name, sect);
			
			if (reader.readLine() == null) {
				break;
			}
		}
	} catch (Exception e) {
		Log.error(e);
		throw new SlickException("Failed to process definitions file - invalid format?", e);
	}
}