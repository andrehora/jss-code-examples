public class Post_postForObject_Example {
 
   static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";
 
   public static void main(String[] args) {
 
      String empNo = "E11";
 
      Employee newEmployee = new Employee(empNo, "Tom", "Cleck");
 
      HttpHeaders headers = new HttpHeaders();
      headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
      headers.setContentType(MediaType.APPLICATION_XML);
 
      RestTemplate restTemplate = new RestTemplate();
 
      // Data attached to the request.
      HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);
 
      // Send request with POST method.
      Employee e = restTemplate.postForObject(URL_CREATE_EMPLOYEE, requestBody, Employee.class);
 
      if (e != null && e.getEmpNo() != null) {
 
         System.out.println("Employee created: " + e.getEmpNo());
      } else {
         System.out.println("Something error!");
      }
 
   }
 
}