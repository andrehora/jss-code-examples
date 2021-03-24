private boolean canThisActionDistinguish(HashSet<Position> thePool, int action) {
    HashSet<Position> pool = (HashSet<Position>) thePool.clone();
    // if action is not valid, return -1
    ArrayList<String> results = new ArrayList<String>();
    for (Position pos : pool) {
        // clone the position (if we use the original one, we need to move
        // it back, which I don't want to do)
        Position copy = pos.clone();
        // simulate the movement
        copy.relativeMove(action);
        results.add(getRelativeOccupiedInfo(copy));
    }
    double diffNum = new HashSet<String>(results).size();
    return diffNum > 1;
}