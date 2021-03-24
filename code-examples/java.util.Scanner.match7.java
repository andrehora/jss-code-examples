protected ThreadStack parseThreadInfo(String threadInfo) {
    Scanner s = new Scanner(threadInfo);
    ThreadStack result = new ThreadStack();

    // parsing thread info
    s.findInLine(threadInfoPattern());
    MatchResult res = s.match();

    result.setThreadName(res.group(1));

    result.setType(res.group(3));

    result.setPriority(res.group(4));
    result.setTid(res.group(7));
    result.setNid(res.group(8));
    result.setStatus(res.group(9));

    s.close();
    return result;
}