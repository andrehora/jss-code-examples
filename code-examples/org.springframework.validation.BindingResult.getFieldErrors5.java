@PostMapping(value = "/saveEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
@ResponseBody
public EmployeeJsonRespone saveEmployee(@ModelAttribute @Valid Employee employee,
		BindingResult result) {

	EmployeeJsonRespone respone = new EmployeeJsonRespone();

	if(result.hasErrors()){

		//Get error message
		Map<String, String> errors = result.getFieldErrors().stream()
				.collect(
						Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
						);

		respone.setValidated(false);
		respone.setErrorMessages(errors);
	}else{
		// Implement business logic to save employee into database
		//..
		respone.setValidated(true);
		respone.setEmployee(employee);
	}
	return respone;
}