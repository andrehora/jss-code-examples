public void testCharactersOfIsView() {
 StringBuilder builder = new StringBuilder("abc");
 List<Character> chars = Lists.charactersOf(builder);
 assertEquals(asList('a', 'b', 'c'), chars);
 builder.append("def");
 assertEquals(asList('a', 'b', 'c', 'd', 'e', 'f'), chars);
 builder.deleteCharAt(5);
 assertEquals(asList('a', 'b', 'c', 'd', 'e'), chars);
}