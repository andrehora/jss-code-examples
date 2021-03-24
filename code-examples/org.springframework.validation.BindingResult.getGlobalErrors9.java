protected JsonResponse populateJsonValidationErrors(EntityForm form, BindingResult result, JsonResponse json) {
    List<Map<String, Object>> errors = new ArrayList<Map<String, Object>>();
    for (FieldError e : result.getFieldErrors()) {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("errorType", "field");
        String fieldName = e.getField().substring(e.getField().indexOf("[") + 1, e.getField().indexOf("]")).replace("_", "-");
        errorMap.put("field", fieldName);
        errorMap.put("message", translateErrorMessage(e));
        errorMap.put("code", e.getCode());
        String tabFieldName = fieldName.replaceAll("-+", ".");
        Tab errorTab = form.findTabForField(tabFieldName);
        if (errorTab != null) {
            errorMap.put("tab", errorTab.getTitle());
        }
        errors.add(errorMap);
    }
    for (ObjectError e : result.getGlobalErrors()) {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("errorType", "global");
        errorMap.put("code", e.getCode());
        errorMap.put("message", translateErrorMessage(e));
        errors.add(errorMap);
    }
    json.with("errors", errors);
    return json;
}