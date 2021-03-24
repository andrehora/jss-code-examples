public void collectionArrayFeatures() {
        /**
         * This test case will present how to work with arrays or collections of primitives thanks to Google Guava. Only one code line is enough to
         * create a List of ints, booleans.. - all Guava's wrappers provide the possibility to convert primitives of some type to List of this type with asList method.
         */
        List<integer> years = Ints.asList(1980, 1985, 1987, 1989, 1991, 2001);
        assertTrue("The 1st entry of the list should be 1980 but is "+years.get(0), years.get(0) == 1980);
        assertTrue("The 2nd entry of the list should be 1980 but is "+years.get(1), years.get(1) == 1985);
        assertTrue("The 3rd entry of the list should be 1980 but is "+years.get(2), years.get(2) == 1987);
        assertTrue("The 4th entry of the list should be 1980 but is "+years.get(3), years.get(3) == 1989);
        assertTrue("The 5th entry of the list should be 1980 but is "+years.get(4), years.get(4) == 1991);
        assertTrue("The 6th entry of the list should be 1980 but is "+years.get(5), years.get(5) == 2001);
}