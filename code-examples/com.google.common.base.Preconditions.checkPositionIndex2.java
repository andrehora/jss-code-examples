public void givenArrayAndMsg_whenCheckPositionEvalsFalse_throwsException() {
    int[] numbers = { 1, 2, 3, 4, 5 };
    String message = "Please check the bound of an array and retry";
  
    assertThatThrownBy(
      () -> Preconditions.checkPositionIndex(6, numbers.length - 1, message))
      .isInstanceOf(IndexOutOfBoundsException.class)
      .hasMessageStartingWith(message).hasNoCause();
}