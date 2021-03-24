private static void getEmployees()
{
    final String uri = "http://localhost:8080/springrestexample/employees.xml";
     
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(uri, String.class);
     
    System.out.println(result);
}