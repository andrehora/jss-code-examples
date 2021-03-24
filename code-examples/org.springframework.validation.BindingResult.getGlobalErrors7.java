public ApiError createBindingResultApiError(WebRequest request, String errorCode, BindingResult bindingResult, String defaultErrorMessage) {
    ApiError apiError = createApiError(request, errorCode, defaultErrorMessage);
    for (FieldError fieldError : bindingResult.getFieldErrors()) {
        apiError.addDetail(createApiError(request, fieldError, fieldError.getField()));
    }
    for (ObjectError objectError : bindingResult.getGlobalErrors()) {
        apiError.addDetail(createApiError(request, objectError, objectError.getObjectName()));
    }
    return apiError;
}