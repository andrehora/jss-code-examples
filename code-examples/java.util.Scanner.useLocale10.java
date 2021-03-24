public static List<ProcessInformations> buildProcessInformations(InputStream in,
		boolean windows, boolean macOrAix) {
	final String charset;
	if (windows) {
		charset = "Cp1252";
	} else {
		charset = "UTF-8";
	}
	final Scanner sc = new Scanner(in, charset);
	sc.useRadix(10);
	sc.useLocale(Locale.US);
	sc.nextLine();
	if (windows) {
		sc.nextLine();
		sc.nextLine();
	}
	final List<ProcessInformations> processInfos = new ArrayList<ProcessInformations>();
	while (sc.hasNext()) {
		final ProcessInformations processInfo = new ProcessInformations(sc, windows, macOrAix);
		processInfos.add(processInfo);
	}
	return Collections.unmodifiableList(processInfos);
}