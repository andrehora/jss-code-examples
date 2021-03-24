private void expandDerivRightwards(Derivation leftChild) {
  if (parser.verbose(6))
    LogInfo.begin_track("Expanding rightward");
  Map<String, List<Rule>> rhsCategoriesToRules = parser.leftToRightSiblingMap.get(leftChild.cat);
  if (rhsCategoriesToRules != null) {
    for (int i = 1; leftChild.end + i <= numTokens; ++i) {
      Set<String> intersection = Sets.intersection(rhsCategoriesToRules.keySet(), chart[leftChild.end][leftChild.end + i].keySet());

      for (String rhsCategory : intersection) {
        List<Rule> compatibleRules = rhsCategoriesToRules.get(rhsCategory);
        List<Derivation> rightChildren = chart[leftChild.end][leftChild.end + i].get(rhsCategory);
        generateParentDerivations(leftChild, rightChildren, true, compatibleRules);
      }
    }
    // handle terminals
    if (leftChild.end < numTokens)
      handleTerminalExpansion(leftChild, false, rhsCategoriesToRules);
  }
  if (parser.verbose(6))
    LogInfo.end_track();
}