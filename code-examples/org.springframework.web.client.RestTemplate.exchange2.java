private static void getEmployees()
{
    final String uri = "http://localhost:8080/springrestexample/employees";
     
    RestTemplate restTemplate = new RestTemplate();
     
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
     
    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
     
    System.out.println(result);
}