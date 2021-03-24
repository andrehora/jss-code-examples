public void validate(Object target, Errors errors) { 
	ValidationUtils.rejectIfEmpty(errors, "username", "required", new Object[] { "Username" }); 
	ValidationUtils.rejectIfEmpty(errors, "password", "required", new Object[] { "Password" }); 
	ValidationUtils.rejectIfEmpty(errors, "emailAddress", "required", new Object[] { "Email address" }); 
	ValidationUtils.rejectIfEmpty(errors, "address.street", "required", new Object[] { "Street" }); 
	ValidationUtils.rejectIfEmpty(errors, "address.city", "required", new Object[] { "City" }); 
	ValidationUtils.rejectIfEmpty(errors, "address.country", "required", new Object[] { "Country" }); 

	if (!errors.hasFieldErrors("emailAddress")) { 
		Account account = (Account) target; 
		String email = account.getEmailAddress(); 
		if (!email.matches(EMAIL_PATTERN)) { 
			errors.rejectValue("emailAddress", "invalid"); 
		} 
	} 
}