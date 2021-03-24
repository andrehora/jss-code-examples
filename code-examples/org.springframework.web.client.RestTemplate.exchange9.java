public void testLogin() {
	try {
		String authUrl = String.format(AUTH_URL_BASE, port);
		JsonObject request = Json.createObjectBuilder()
				.add("id", DEFAULT_ID)
				.add("key", DEFAULT_KEY)
				.build();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);
		RestTemplate rest = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		ResponseEntity<String> response = rest.exchange(authUrl, HttpMethod.POST, entity, String.class);

		assertEquals(200, response.getStatusCodeValue());
		JsonReader reader = Json.createReader(new StringReader(response.getBody()));
		JsonObject o = reader.readObject();
		String token = o.getString("token");
		assertTrue(!StringUtils.isEmpty(token));
		logger.info(token);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		fail(e.getMessage());
	}
}