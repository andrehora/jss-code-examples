public ValidationErrorMessage createBody(MethodArgumentNotValidException ex, HttpServletRequest req) {
    ErrorMessage tmpl = super.createBody(ex, req);
    ValidationErrorMessage msg = new ValidationErrorMessage(tmpl);
    BindingResult result = ex.getBindingResult();
    for (ObjectError err : result.getGlobalErrors()) {
        msg.addError(err.getDefaultMessage());
    }
    for (FieldError err : result.getFieldErrors()) {
        msg.addError(err.getField(), err.getRejectedValue(), err.getDefaultMessage());
    }
    return msg;
}