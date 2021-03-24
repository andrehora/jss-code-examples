public void sync() throws IOException {
	InputStream csv = IOUtils.toInputStream(sgc2csv(null).toString(), ENCODING_P2S);
	AppliConfig appliConfig = AppliConfig.findAppliConfigByKey("P2S_EXPORT_CSV_FILE_NAME");
	String filename = appliConfig.getValue();
	Date date = new Date();
	p2sVfsAccessService.putFile(null, date.getTime() + "_" + filename, csv, false);
}