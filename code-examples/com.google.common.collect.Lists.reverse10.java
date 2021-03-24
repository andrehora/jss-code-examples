private String getErrorMessage(String initMsg) {
    List<String> locators = Lists.reverse(getLocators());
    if (locators.size() > 0) {
        initMsg += ": ";
        StringJoiner joiner = new StringJoiner(", ");
        for (String loc : locators) {
            joiner.add(loc);
        }
        initMsg += joiner.toString();
    }
    initMsg += " " + configError;
    return initMsg;
}