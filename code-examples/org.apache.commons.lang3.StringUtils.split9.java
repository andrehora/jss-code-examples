protected static java.util.List<GenomeLoc> getIntervals(RefContigInfo refContigInfo, String filePath) {
    String intervalPath = TestRealignerTargetCreator.class.getResource(filePath).getFile();
    java.util.List<GenomeLoc> intervals = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File(intervalPath)))) {
        String line = reader.readLine();
        while (line != null) {
            if(line.length() > 0 && !line.startsWith("@")) {
                String[] split = StringUtils.split(line, '\t');
                String contigName = split[0];
                int contigId = refContigInfo.getId(contigName);
                int start = Integer.parseInt(split[1]);
                int stop = Integer.parseInt(split[2]);
                intervals.add(new GenomeLoc(contigName, contigId, start, stop));
            }
            line = reader.readLine();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return intervals;
}