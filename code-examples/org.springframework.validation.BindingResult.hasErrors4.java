@RequestMapping(method = RequestMethod.POST)
public String submitForm(@ModelAttribute("employee") EmployeeVO employeeVO,
                        BindingResult result, SessionStatus status)
{
     
    //Validation code
    validator.validate(employeeVO, result);
     
    //Check validation errors
    if (result.hasErrors()) {
        return "addEmployee";
    }
     
    //Store the employee information in database
    //manager.createNewRecord(employeeVO);
     
    //Mark Session Complete
    status.setComplete();
    return "redirect:addNew/success";
}