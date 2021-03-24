public void testCharSequenceToInputStream() throws Exception {
	CharSequence csq = new StringBuilder("Abc123Xyz!");
	InputStream inStream = IOUtils.toInputStream(csq);
	byte[] bytes = IOUtils.toByteArray(inStream);
	assertEqualContent(csq.toString().getBytes(), bytes);
	inStream = IOUtils.toInputStream(csq, null);
	bytes = IOUtils.toByteArray(inStream);
	assertEqualContent(csq.toString().getBytes(), bytes);
	inStream = IOUtils.toInputStream(csq, "UTF-8");
	bytes = IOUtils.toByteArray(inStream);
	assertEqualContent(csq.toString().getBytes("UTF-8"), bytes);
}