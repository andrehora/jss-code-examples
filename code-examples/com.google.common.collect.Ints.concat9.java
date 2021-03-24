public static IComplexNDArray repeat(IComplexNDArray n, int num) {
  List<IComplexNDArray> list = new ArrayList<>();
  for (int i = 0; i < num; i++)
    list.add(n.dup());
  IComplexNDArray ret = Nd4j.createComplex(list, Ints.concat(new int[] {num}, n.shape()));
  logCreationIfNecessary(ret);
  return ret;
}