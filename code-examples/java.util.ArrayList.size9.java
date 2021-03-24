public static ArrayList<Projection> combine(final UWorld world, final ArrayList<Structure> village, final int chunkX, final int chunkZ, final long seed) {
	ArrayList<Projection> projections = new ArrayList<>();
	Random random = new Random(seed);
	String villageName = village.get(0).getFile().getParent();
	int side = (int) (1 + Math.sqrt(village.size()));
	for (int i = 0, maxSize = 0, offsetX = 0, offsetZ = 0; i < village.size(); ++i) {
		int posX = i % side;
		if (posX == 0) {
			offsetX = 0;
			offsetZ += maxSize;
			maxSize = 0;
		}
		Structure structure = village.get(i);
		int realX = chunkX * 16 + offsetX;
		int realZ = chunkZ * 16 + offsetZ;
		int curSize = Math.max(structure.getWidth(), structure.getLength());
		maxSize = Math.max(maxSize, curSize);
		offsetX += maxSize;
		if (!Limiter.isStructureLimitExceeded(world, structure)) {
			Projection projection = construct(world, realX, realZ, random.nextLong(), structure);
			if (projection != null) {
				projections.add(projection);
				Limiter.useStructure(world, structure);
			}
		}
	}
	new Report().post("VILLAGE", villageName).post("CHUNK", "[X=" + chunkX + ";Z=" + chunkZ + "]").post("TOTAL SPAWNED", String.valueOf(projections.size())).print();
	return projections;
}