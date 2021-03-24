public void givenStatesAndMsg_whenCheckStateEvalsFalse_throwsException() {
    int[] validStates = { -1, 0, 1 };
    int givenState = 10;
    String message = "You have entered an invalid state";
  
    assertThatThrownBy(
      () -> Preconditions.checkState(
        Arrays.binarySearch(validStates, givenState) > 0, message))
      .isInstanceOf(IllegalStateException.class)
      .hasMessageStartingWith(message).hasNoCause();
}