private ModelAndView processBindingResult(Exception exception, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (request.getHeaders("X-Requested-With").hasMoreElements() && bindingResult.hasFieldErrors()) {
        //AJAX request;
        Map<String, List<String>> errorMap = validationManager.getErrorsAsMap(bindingResult);
        String content = validationManager.getMessageJSON(errorMap).toString();
        response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        response.setContentLength(content.getBytes(Charset.forName(response.getCharacterEncoding())).length);
        response.getWriter().print(content);
        response.flushBuffer();
        return null;
    } else {
        //Non-AJAX request
        return MvcExceptionHandler.handle(exception, request, response);
    }
}