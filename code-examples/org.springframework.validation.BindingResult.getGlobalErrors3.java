@ExceptionHandler(BindException.class) // (1)
@ResponseStatus(value = HttpStatus.BAD_REQUEST) // (2)
@ResponseBody // (3)
public ErrorResults handleBindException(BindException e, Locale locale) { // (4)
	// (5)
	ErrorResults errorResults = new ErrorResults();
	for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
		errorResults.add(fieldError.getCode(),
				messageSource.getMessage(fieldError, locale),
				fieldError.getField());
	}
	for (ObjectError objectError : e.getBindingResult().getGlobalErrors()) {
		errorResults.add(objectError.getCode(),
				messageSource.getMessage(objectError, locale),
				objectError.getObjectName());
	}
	return errorResults;
}