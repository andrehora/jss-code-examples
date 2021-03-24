@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public ErrorVM processValidationError(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();
    ErrorVM dto = new ErrorVM(ErrorConstants.ERR_VALIDATION);
    for (FieldError fieldError : fieldErrors) {
        dto.add(fieldError.getObjectName(), fieldError.getField(), fieldError.getCode());
    }
    return dto;
}