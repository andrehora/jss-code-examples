private static void createEmployee()
{
    final String uri = "http://localhost:8080/springrestexample/employees";
 
    EmployeeVO newEmployee = new EmployeeVO(-1, "Adam", "Gilly", "test@email.com");
 
    RestTemplate restTemplate = new RestTemplate();
    EmployeeVO result = restTemplate.postForObject( uri, newEmployee, EmployeeVO.class);
 
    System.out.println(result);
}