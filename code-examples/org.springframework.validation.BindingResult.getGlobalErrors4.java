protected ResponseEntity<Object> handleBindException
  (BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    logger.error("400 Status Code", ex);
    BindingResult result = ex.getBindingResult();
    GenericResponse bodyOfResponse = 
      new GenericResponse(result.getFieldErrors(), result.getGlobalErrors());
     
    return handleExceptionInternal(
      ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
}