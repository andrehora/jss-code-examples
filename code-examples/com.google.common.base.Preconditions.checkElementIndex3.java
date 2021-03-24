public void givenArrayAndMsg_whenCheckElementEvalsFalse_throwsException() {
    int[] numbers = { 1, 2, 3, 4, 5 };
    String message = "Please check the bound of an array and retry";
  
    assertThatThrownBy(() -> 
      Preconditions.checkElementIndex(6, numbers.length - 1, message))
      .isInstanceOf(IndexOutOfBoundsException.class)
      .hasMessageStartingWith(message).hasNoCause();
}