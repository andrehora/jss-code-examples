void setUp() {
  this.striped = impl.get(numStripes);
  stripes = new int[numStripes];
  for (int i = 0; i < numStripes; i++) {
    stripes[i] = i;
  }
  List<Integer> asList = Ints.asList(stripes);
  Collections.shuffle(asList, new Random(0xdeadbeef));

  // do bulk gets with exactly 10 keys (possibly <10 stripes) (or less if numStripes is smaller)
  bulkGetSet = ImmutableList.copyOf(limit(cycle(asList), 10));
}