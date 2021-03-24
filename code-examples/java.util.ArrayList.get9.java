private void prepareMonoPixelMap() {
	int[] row_cache = null;
	final int line = rgbData.length;
	final int column = rgbData[0].length;
	ArrayList<Point> al = new ArrayList<Point>();

	// Point first = null;

	for (int y = 0; y < line; y++) {
		row_cache = rgbData[y];
		for (int x = 0; x < column; x++)
			if (row_cache[x] == monoColor)
				al.add(new Point(x, y));
	}

	monoXY_Map = new int[2][al.size()];
	for (int i = 0; i < al.size(); i++) {
		Point p = (Point) al.get(i);
		monoXY_Map[0][i] = (int) p.getX();
		monoXY_Map[1][i] = (int) p.getY();
	}
	rgbData = null;
}