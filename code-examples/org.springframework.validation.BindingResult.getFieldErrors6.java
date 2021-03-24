@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ResponseEntity<?> processHandler(MethodArgumentNotValidException ex) {

  BindingResult bindingResult = ex.getBindingResult();
  List<FieldError> fieldErrors = bindingResult.getFieldErrors();
  List<FieldErrorDto> fieldErrorDtos = fieldErrors.stream()
      .map(FieldErrorDto::new)
      .collect(Collectors.toList());

  ValidationResultDto validationResultDto = new ValidationResultDto();
  validationResultDto.setFieldErrors(fieldErrorDtos);

  LOGGER.error("VALIDATION ERROR: " + ex.getMessage());

  return ResponseEntity.badRequest().body(validationResultDto);
}