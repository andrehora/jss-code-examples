public void forTree_depthFirstPostOrderIterable_singleRoot() {
 Iterable<Character> result =
   Traverser.forTree(SINGLE_ROOT).depthFirstPostOrder(charactersOf("a"));
 assertEqualCharNodes(result, "a");
}