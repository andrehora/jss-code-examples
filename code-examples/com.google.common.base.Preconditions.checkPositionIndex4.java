public void testCheckPositionIndex_ok() {
    assertEquals(0, Preconditions.checkPositionIndex(0, 0));
    assertEquals(0, Preconditions.checkPositionIndex(0, 1));
    assertEquals(1, Preconditions.checkPositionIndex(1, 1));
  }