ModelAndView model = new ModelAndView("employeeDetails");
model.addObject("employeeObj", new EmployeeBean(123));
model.addObject("msg", "Employee information.");
return model;