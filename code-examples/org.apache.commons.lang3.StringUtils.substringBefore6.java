public static MarkPos fromString(@Nullable String str) {
	if (str != null) {
		String commit = StringUtils.substringBefore(str, ":");
		String path = null;
		TextRange mark = null;
		String pathAndMark = StringUtils.substringAfter(str, ":");
		if (pathAndMark.length() != 0) {
			path = StringUtils.substringBefore(pathAndMark, ":");
			String markStr = StringUtils.substringAfter(pathAndMark, ":");
			if (markStr.length() != 0)
				mark = new TextRange(markStr);
		}
		return new MarkPos(commit, path, mark);
	} else {
		return null;
	}
}