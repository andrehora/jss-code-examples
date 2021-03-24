public void run_on_valid_response() throws Exception {
    MockHttpServletRequest request = new MockHttpServletRequest("GET", "/service1" + DEFAULT_URL);
    RequestContext context = RequestContext.getCurrentContext();
    context.setRequest(request);

    MockHttpServletResponse response = new MockHttpServletResponse();
    context.setResponseGZipped(false);
    context.setResponse(response);

    InputStream in = IOUtils.toInputStream("{\"basePath\":\"/\"}", StandardCharsets.UTF_8);
    context.setResponseDataStream(in);

    filter.run();

    assertEquals("UTF-8", response.getCharacterEncoding());
    assertEquals("{\"basePath\":\"/service1\"}", context.getResponseBody());
}