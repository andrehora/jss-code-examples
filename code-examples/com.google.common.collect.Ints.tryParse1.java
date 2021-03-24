public void givenString_whenTryParse_shouldConvertToInt() {
    String givenString = "42";
 
    Integer result = Ints.tryParse(givenString);
 
    assertThat(result).isEqualTo(42);
}