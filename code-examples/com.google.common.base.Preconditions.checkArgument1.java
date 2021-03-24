public void whenCheckArgumentEvaluatesFalse_throwsException() {
    int age = -18;
  
    assertThatThrownBy(() -> Preconditions.checkArgument(age > 0))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage(null).hasNoCause();
}