public void whenCheckNotNullWithTemplateMessage_throwsException() {
    String nullObject = null;
    String message = "Please check the Object supplied, its %s!";
  
    assertThatThrownBy(
      () -> Preconditions.checkNotNull(nullObject, message, 
        new Object[] { null }))
      .isInstanceOf(NullPointerException.class)
      .hasMessage(message, nullObject).hasNoCause();
}