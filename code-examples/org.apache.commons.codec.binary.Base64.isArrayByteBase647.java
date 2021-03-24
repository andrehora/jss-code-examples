public static byte[] decodeIfNeeded(byte[] recv) {
	boolean arrayByteBase64 = Base64.isArrayByteBase64(recv);
	if (LOG.isDebugEnabled() && arrayByteBase64) {
		LOG.debug("Data only contains Base64 alphabets only so try to decode the data.");
	}
	return arrayByteBase64 ? Base64.decodeBase64(recv) : recv;
}