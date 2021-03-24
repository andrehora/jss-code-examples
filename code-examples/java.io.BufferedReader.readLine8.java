public static void makeMap() {
	try {
		InputStream is = EtFuturum.class.getResourceAsStream("/assets/OceanMonument.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String s;
		while ((s = br.readLine()) != null) {
			String[] data = s.split("-");
			data[0] = data[0].trim();
			data[0] = data[0].substring(1, data[0].length() - 1);

			data[1] = data[1].trim();

			String[] coords = data[0].split(",");

			WorldCoord key = new WorldCoord(Integer.parseInt(coords[0].trim()), Integer.parseInt(coords[1].trim()), Integer.parseInt(coords[2].trim()));
			int value = Integer.parseInt(data[1]);

			map.put(key, value);
		}

		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}