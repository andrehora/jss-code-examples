protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

	BindingResult bindingResult = ex.getBindingResult();
	List<FieldError> fieldErrors = bindingResult.getFieldErrors();
	List<ApiError> apiErrors = fieldErrors.stream()
			.map(this::createApiError)
			.collect(Collectors.toList());
	List<ObjectError> globalErrors = bindingResult.getGlobalErrors();
	apiErrors.addAll(globalErrors.stream()
			.map(e -> new ApiError(e.getCode(), null, e.getDefaultMessage()))
			.collect(Collectors.toList()));

	return new ResponseEntity(apiErrors, status);
}