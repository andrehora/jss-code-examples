public ResultMatcher attributeHasFieldErrorCode(final String name, final String fieldName, final String error) {
    return new ResultMatcher() {

        public void match(MvcResult mvcResult) throws Exception {
            ModelAndView mav = getModelAndView(mvcResult);
            BindingResult result = getBindingResult(mav, name);
            assertTrue("No errors for attribute: [" + name + "]", result.hasErrors());
            boolean hasFieldErrors = result.hasFieldErrors(fieldName);
            assertTrue("No errors for field: [" + fieldName + "] of attribute [" + name + "]", hasFieldErrors);
            String code = result.getFieldError(fieldName).getCode();
            assertTrue("Expected error code '" + error + "' but got '" + code + "'", code.equals(error));
        }
    };
}