public static void docxToHtml(String docxFilePath, String htmlPath) throws Exception {
	OutputStream output = null;
	try {
		//
		WordprocessingMLPackage wmlPackage = WordprocessingMLPackage.load(new File(docxFilePath));

		WMLPACKAGE_BUILDER.configChineseFonts(wmlPackage).configSimSunFont(wmlPackage);
		
		WMLPACKAGE_WRITER.writeToHtml(wmlPackage, htmlPath);

	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		IOUtils.closeQuietly(output);
	}

}