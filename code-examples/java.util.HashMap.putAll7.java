private void multipartCommit() throws Exception {
	final HashMap<String, RequestBody> params = new HashMap<>();
	params.putAll(upload.baseParams);
	params.put("part", Util.createStringPart(Integer.toString(container.num)));

	RetryNetworkFunc<ResponseBody> func;
	func = new RetryNetworkFunc<ResponseBody>(5, 5, Upload.DELAY_BASE) {
		@Override
		Response<ResponseBody> work() throws Exception {
			return Networking.getUploadService().commit(params).execute();
		}
	};

	func.call();
}