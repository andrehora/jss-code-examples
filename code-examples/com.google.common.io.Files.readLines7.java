public static List<Integer> parseExcludeIds() {
    String businessLog = "business.log";

    try {
        List<String> lines = Files.readLines(new File(LOG_BASE_PATH + "/" + businessLog), Charset.defaultCharset());
        return lines.stream()
                .filter(line -> line.contains("-get urls"))
                .map(line -> {
                    Matcher matcher = ID_PATTERN.matcher(line);
                    if (matcher.find()) {
                        return Integer.valueOf(matcher.group(1).trim());
                    }
                    return 0;
                }).filter(id -> id != 0).collect(Collectors.toList());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}