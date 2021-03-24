public void forTree_breadthFirstIterable_emptyGraph() {
 assertEqualCharNodes(
   Traverser.forTree(createDirectedGraph()).breadthFirst(charactersOf("")), "");
 try {
  Traverser.forTree(createDirectedGraph()).breadthFirst(charactersOf("a"));
  fail("Expected IllegalArgumentException");
 } catch (IllegalArgumentException expected) {
 }
}