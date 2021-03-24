public List<Character> create(Character[] elements) {
  char[] chars = Chars.toArray(Arrays.asList(elements));
  StringBuilder str = new StringBuilder();
  str.append(chars);
  return Lists.charactersOf(str);
}