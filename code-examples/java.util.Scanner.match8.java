protected MethodInfo parseMethodInfo(String line) {

	MethodInfo result = new MethodInfo();
	Scanner s = new Scanner(line);

	s.findInLine(methodInfoPattern());
	MatchResult rexp = s.match();
	if (rexp.group(4) != null && rexp.group(4).length() > 0) {
		// line "  at tmtools.jstack.share.utils.Utils.sleep(Utils.java:29)"
		result.setName(rexp.group(1));
		result.setCompilationUnit(rexp.group(2));
		result.setLine(rexp.group(4));

	} else {
		// line "  at java.lang.Thread.sleep(Native Method)"
		result.setName(rexp.group(1));
	}

	s.close();
	return result;
}