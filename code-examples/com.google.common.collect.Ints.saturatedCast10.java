int indexOf(Object target) {
  if (contains(target)) {
    @SuppressWarnings("unchecked") // if it's contained, it's definitely a C
    C c = (C) target;
    long total = 0;
    for (Range<C> range : ranges) {
      if (range.contains(c)) {
        return Ints.saturatedCast(total + ContiguousSet.create(range, domain).indexOf(c));
      } else {
        total += ContiguousSet.create(range, domain).size();
      }
    }
    throw new AssertionError("impossible");
  }
  return -1;
}