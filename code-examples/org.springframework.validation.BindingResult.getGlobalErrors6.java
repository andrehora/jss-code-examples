@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public ErrorVM processValidationError(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    FieldErrorVM dto = new FieldErrorVM(ErrorConstants.ERR_VALIDATION, translate(ErrorConstants.ERR_VALIDATION));
    for (FieldError fieldError : result.getFieldErrors()) {
        dto.add(fieldError.getObjectName(), fieldError.getField(), fieldError.getCode());
    }
    for (ObjectError globalError : result.getGlobalErrors()) {
        dto.add(globalError.getObjectName(), globalError.getObjectName(), globalError.getCode());
    }
    return dto;
}