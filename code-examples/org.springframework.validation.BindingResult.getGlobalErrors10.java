public static List<String> getGlobalErrors(MessageSource messageSource, BindingResult bindingResult, Locale locale) {
    List<String> globalErrors = new ArrayList<String>();
    for (ObjectError oe : bindingResult.getGlobalErrors()) {
        String message = getMessage(messageSource, oe, locale);
        globalErrors.add(message);
    }
    return globalErrors;
}