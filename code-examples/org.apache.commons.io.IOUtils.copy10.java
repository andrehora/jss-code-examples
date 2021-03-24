private String responseBody(RequestContext context) throws IOException {
  try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(STREAM_BUFFER_SIZE.get())) {
    IOUtils.copy(context.getResponseDataStream(), outputStream);
    context.setResponseBody(outputStream.toString());
    return outputStream.toString();
  }
}