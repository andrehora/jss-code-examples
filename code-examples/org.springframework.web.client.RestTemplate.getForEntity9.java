public void testErrorsSerializedAsJsonApi() throws IOException {
	RestTemplate testRestTemplate = new RestTemplate();
	try {
		testRestTemplate
				.getForEntity("http://localhost:" + this.port + "/doesNotExist", String.class);
		Assert.fail();
	}
	catch (HttpClientErrorException e) {
		assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());

		String body = e.getResponseBodyAsString();
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(JacksonModule.createJacksonModule());
		Document document = mapper.readerFor(Document.class).readValue(body);

		Assert.assertEquals(1, document.getErrors().size());
		ErrorData errorData = document.getErrors().get(0);
		Assert.assertEquals("404", errorData.getStatus());
		Assert.assertEquals("Not Found", errorData.getTitle());
		Assert.assertEquals("No message available", errorData.getDetail());
	}
}