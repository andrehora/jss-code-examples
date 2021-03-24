public static List<BakedQuad> createBakedQuadCuboid(float x1, float y1, float z1, float x2, float y2, float z2, TextureAtlasSprite sprite, int red, int green, int blue, int alpha) {
	List<BakedQuad> quads = new ArrayList<BakedQuad>();
	
	int color = (alpha & 0x0ff) << 24 | (blue & 0x0ff) << 16 | (green & 0x0ff) << 8 | (red & 0x0ff);
	int[] vertexData;
	
	vertexData = Ints.concat(
			vertexToInts(x2, y2, z1, color, sprite, x2 * 16, y1 * 16),
			vertexToInts(x2, y1, z1, color, sprite, x2 * 16, y2 * 16),
			vertexToInts(x1, y1, z1, color, sprite, x1 * 16, y2 * 16),
			vertexToInts(x1, y2, z1, color, sprite, x1 * 16, y1 * 16));
	quads.add(new BakedQuad(vertexData, 0, EnumFacing.NORTH, sprite, false, DefaultVertexFormats.BLOCK));
	vertexData = Ints.concat(
			vertexToInts(x1, y2, z2, color, sprite, x1 * 16, y1 * 16),
			vertexToInts(x1, y1, z2, color, sprite, x1 * 16, y2 * 16),
			vertexToInts(x2, y1, z2, color, sprite, x2 * 16, y2 * 16),
			vertexToInts(x2, y2, z2, color, sprite, x2 * 16, y1 * 16));
	quads.add(new BakedQuad(vertexData, 0, EnumFacing.SOUTH, sprite, false, DefaultVertexFormats.BLOCK));
	vertexData = Ints.concat(
			vertexToInts(x1, y2, z1, color, sprite, z1 * 16, y1 * 16),
			vertexToInts(x1, y1, z1, color, sprite, z1 * 16, y2 * 16),
			vertexToInts(x1, y1, z2, color, sprite, z2 * 16, y2 * 16),
			vertexToInts(x1, y2, z2, color, sprite, z2 * 16, y1 * 16));
	quads.add(new BakedQuad(vertexData, 0, EnumFacing.WEST, sprite, false, DefaultVertexFormats.BLOCK));
	vertexData = Ints.concat(
			vertexToInts(x2, y2, z2, color, sprite, z2 * 16, y1 * 16),
			vertexToInts(x2, y1, z2, color, sprite, z2 * 16, y2 * 16),
			vertexToInts(x2, y1, z1, color, sprite, z1 * 16, y2 * 16),
			vertexToInts(x2, y2, z1, color, sprite, z1 * 16, y1 * 16));
	quads.add(new BakedQuad(vertexData, 0, EnumFacing.EAST, sprite, false, DefaultVertexFormats.BLOCK));
	vertexData = Ints.concat(
			vertexToInts(x2, y1, z1, color, sprite, x2 * 16, z1 * 16),
			vertexToInts(x2, y1, z2, color, sprite, x2 * 16, z2 * 16),
			vertexToInts(x1, y1, z2, color, sprite, x1 * 16, z2 * 16),
			vertexToInts(x1, y1, z1, color, sprite, x1 * 16, z1 * 16));
	quads.add(new BakedQuad(vertexData, 0, EnumFacing.DOWN, sprite, false, DefaultVertexFormats.BLOCK));
	vertexData = Ints.concat(
			vertexToInts(x1, y2, z1, color, sprite, x1 * 16, z1 * 16),
			vertexToInts(x1, y2, z2, color, sprite, x1 * 16, z2 * 16),
			vertexToInts(x2, y2, z2, color, sprite, x2 * 16, z2 * 16),
			vertexToInts(x2, y2, z1, color, sprite, x2 * 16, z1 * 16));
	quads.add(new BakedQuad(vertexData, 0, EnumFacing.UP, sprite, false, DefaultVertexFormats.BLOCK));
	
	return quads;
}