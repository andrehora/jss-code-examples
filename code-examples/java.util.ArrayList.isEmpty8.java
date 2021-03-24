public List getCreateEvents() {
  if (this.events == null) {
    return Collections.EMPTY_LIST;
  } else {
    ArrayList result = new ArrayList(this.events.size());
    Iterator it = this.events.iterator();
    while (it.hasNext()) {
      CacheEvent ce = (CacheEvent) it.next();
      if (ce.getOperation().isCreate() && isEventUserVisible(ce)) {
        result.add(ce);
      }
    }
    if (result.isEmpty()) {
      return Collections.EMPTY_LIST;
    } else {
      return Collections.unmodifiableList(result);
    }
  }
}