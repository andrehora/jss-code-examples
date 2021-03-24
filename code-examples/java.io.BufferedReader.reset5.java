public void givenBufferedReader_whenSkipsWhitespacesAtBeginning_thenOk() 
  throws IOException {
    String result;
 
    try (BufferedReader reader = 
           new BufferedReader(new StringReader("    Lorem ipsum dolor sit amet."))) {
        do {
            reader.mark(1);
        } while(Character.isWhitespace(reader.read()))
 
        reader.reset();
        result = reader.readLine();
    }
 
    assertEquals("Lorem ipsum dolor sit amet.", result);
}