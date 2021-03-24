public void collectionArrayFeatures() {
/**
  * Thanks to Google Guava we can also simply concatenate two or more arrays. Once again, this example shows the feature for arrays but it can be applied to all wrappers
         * (Ints, Doubles, Longs, Shorts, Booleans, Bytes, Floats and Chars).
         */
        int[] century18 = new int[]{1750, 1790};
        int[] century19 = new int[]{1850, 1890};
        int[] century20 = new int[]{1950, 1990};
        int[] allYears = Ints.concat(century18, century19, century20);
        assertTrue("allYears[0] should be 1750 but is "+allYears[0], allYears[0] == 1750);
        assertTrue("allYears[1] should be 1750 but is "+allYears[1], allYears[1] == 1790);
        assertTrue("allYears[2] should be 1750 but is "+allYears[2], allYears[2] == 1850);
        assertTrue("allYears[3] should be 1750 but is "+allYears[3], allYears[3] == 1890);
        assertTrue("allYears[4] should be 1750 but is "+allYears[4], allYears[4] == 1950);
        assertTrue("allYears[5] should be 1750 but is "+allYears[5], allYears[5] == 1990);
}