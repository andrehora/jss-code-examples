private void assertEntityValidity(BindingResult bindingResult) throws DtoValidationFailedException {
	if (bindingResult.hasErrors()) {
		throw new DtoValidationFailedException("Validation failed!", bindingResult.getFieldErrors());
	}
}