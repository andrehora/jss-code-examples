private void setWinCeVersion(OperatingSystem model) {
    //TODO: to be refined
    String osV = model.getVersion();
    if (osV == null) {
        return;

    } else if (!model.getMajorRevision().equals("1")) {
        return;
    }

    if (osV.matches(".*(\\d+).(\\d+).(\\d+).(\\d+).*")) {
        Scanner s = new Scanner(osV);
        s.findInLine(".*(\\d+).(\\d+).(\\d+).(\\d+).*");
        MatchResult result = s.match();
        if (result.group(1).equals("4")) {
            model.setMajorRevision("5");

        } else if (result.group(1).equals("6")) {
            model.setMajorRevision("6");

            if (result.group(3).equals("7")) {
                model.setMinorRevision("1");
            }
        }
    }
}