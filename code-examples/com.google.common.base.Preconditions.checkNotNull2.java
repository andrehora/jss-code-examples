public void givenNullString_whenCheckNotNullWithMessage_throwsException () {
    String nullObject = null;
    String message = "Please check the Object supplied, its null!";
  
    assertThatThrownBy(() -> Preconditions.checkNotNull(nullObject, message))
      .isInstanceOf(NullPointerException.class)
      .hasMessage(message).hasNoCause();
}