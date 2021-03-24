protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	logger.info(ex.getClass().getName());
	//
	final List<String> errors = new ArrayList<String>();
	for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
		errors.add(error.getField() + ": " + error.getDefaultMessage());
	}
	for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
		errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	}
	final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
}