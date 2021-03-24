public void publishShuffleAndProof(int j, List<Encryption> shuffle, ShuffleProof proof) {
    Preconditions.checkElementIndex(j, publicParameters.getS(),
            "j needs to be within bounds");
    Preconditions.checkArgument(shuffles.size() == j,
            "Shuffle j can only be inserted after the previous shuffles");
    Preconditions.checkArgument(shuffleProofs.size() == j,
            "Shuffle proof j can only be inserted after the previous shuffle proof");
    shuffles.put(j, shuffle);
    shuffleProofs.put(j, proof);
}