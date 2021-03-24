public static boolean checkConnection(String url,String auth){
	boolean flag = false;
	try {
		HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
		connection.setConnectTimeout(5*1000);
		if(auth!=null&&!"".equals(auth)){
			String authorization = "Basic "+new String(Base64.encodeBase64(auth.getBytes()));
			connection.setRequestProperty("Authorization", authorization);
		}
		connection.connect();
		if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){
			flag = true;
		}
		connection.disconnect();
	}catch (Exception e) {
		logger.error("--Server Connect Error !",e);
	}
	return flag;
}