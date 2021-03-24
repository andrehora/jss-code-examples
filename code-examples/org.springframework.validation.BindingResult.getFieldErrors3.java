private String resolveBindingResultErrors(BindingResult bindingResult) {
	return bindingResult.getFieldErrors().stream()
			.map(fr -> {
				String field = fr.getField();
				String validationMessage = fr.getDefaultMessage();
				return format("'%s': %s", field, validationMessage);
			}).
			.collect(joining(", "));
}