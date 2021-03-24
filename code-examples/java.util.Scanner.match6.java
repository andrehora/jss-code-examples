private int parseYear(Scanner s, int defaultYear) {
    if (s.hasNext(YEAR)) {
        s.next(YEAR);
        MatchResult mr = s.match();
        if (mr.group(1) != null) {
            return 1900;  // systemv has min
        } else if (mr.group(2) != null) {
            return YEAR_MAX_VALUE;
        } else if (mr.group(3) != null) {
            return defaultYear;
        }
        return Integer.parseInt(mr.group(4));
        /*
        if (mr.group("min") != null) {
            //return YEAR_MIN_VALUE;
            return 1900;  // systemv has min
        } else if (mr.group("max") != null) {
            return YEAR_MAX_VALUE;
        } else if (mr.group("only") != null) {
            return defaultYear;
        }
        return Integer.parseInt(mr.group("year"));
        */
    }
    throw new IllegalArgumentException("Unknown year: " + s.next());
}