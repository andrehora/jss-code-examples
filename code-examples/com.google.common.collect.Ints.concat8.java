public void testConcat() {
 assertTrue(Arrays.equals(EMPTY, Ints.concat()));
 assertTrue(Arrays.equals(EMPTY, Ints.concat(EMPTY)));
 assertTrue(Arrays.equals(EMPTY, Ints.concat(EMPTY, EMPTY, EMPTY)));
 assertTrue(Arrays.equals(ARRAY1, Ints.concat(ARRAY1)));
 assertNotSame(ARRAY1, Ints.concat(ARRAY1));
 assertTrue(Arrays.equals(ARRAY1, Ints.concat(EMPTY, ARRAY1, EMPTY)));
 assertTrue(
   Arrays.equals(new int[] {(int) 1, (int) 1, (int) 1}, Ints.concat(ARRAY1, ARRAY1, ARRAY1)));
 assertTrue(
   Arrays.equals(
     new int[] {(int) 1, (int) 2, (int) 3, (int) 4}, Ints.concat(ARRAY1, ARRAY234)));
}