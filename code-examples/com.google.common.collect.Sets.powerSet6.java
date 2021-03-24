private void initPowersetIterator() {
    // Create set of definition with leftover quantities
    Set<T> leftOverQuantities = new HashSet<>();
    for (T def : allDefintions) {
        if (roundSize.get(def) < def.numberOfLicenses()) {
            leftOverQuantities.add(def);
        }
    }
    if (leftOverQuantities.size() == 0) {
        hasNext = false;
        return;
    } else {
        hasNext = true;
        Set<Set<T>> definitionPowerset = Sets.powerSet(leftOverQuantities);
        List<Set<T>> sorted = new ArrayList<>(definitionPowerset);
        sorted.sort(getIncreasingSizeComparator());
        definitionPowersetIterator = sorted.iterator();
    }

}