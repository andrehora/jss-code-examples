public int size() {
  // racy single-check idiom
  Integer result = size;
  if (result == null) {
    long total = 0;
    for (Range<C> range : ranges) {
      total += ContiguousSet.create(range, domain).size();
      if (total >= Integer.MAX_VALUE) {
        break;
      }
    }
    result = size = Ints.saturatedCast(total);
  }
  return result.intValue();
}