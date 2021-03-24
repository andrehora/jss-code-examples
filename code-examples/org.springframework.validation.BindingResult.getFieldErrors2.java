List<FieldError> errors = bindingResult.getFieldErrors();
for (FieldError error : errors ) {
	System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
}