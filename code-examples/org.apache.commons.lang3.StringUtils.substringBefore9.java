public TextRange(String markStr) {
	String begin = StringUtils.substringBefore(markStr, "-");
	String end = StringUtils.substringAfter(markStr, "-");
	beginLine = Integer.parseInt(StringUtils.substringBefore(begin, "."))-1;
	beginChar = Integer.parseInt(StringUtils.substringAfter(begin, "."));
	endLine = Integer.parseInt(StringUtils.substringBefore(end, "."))-1;
	endChar = Integer.parseInt(StringUtils.substringAfter(end, "."));
}