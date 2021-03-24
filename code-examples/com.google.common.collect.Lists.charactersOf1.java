public void whenCreateCharacterListFromString_thenCreated() {
    List<Character> chars = Lists.charactersOf("John");
 
    assertEquals(4, chars.size());
    assertThat(chars, contains('J', 'o', 'h', 'n'));
}