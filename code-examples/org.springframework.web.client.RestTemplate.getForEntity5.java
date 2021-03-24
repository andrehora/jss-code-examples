public class UserClient {

  public static void main(String[] args) {
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<String> responseEntity = restTemplate.getForEntity(
              "http://localhost:8080/users/40", String.class);
      System.out.println("-- response --");
      System.out.println("status: "+responseEntity.getStatusCodeValue());
      System.out.println("headers: "+responseEntity.getHeaders().toSingleValueMap());
      System.out.println("body: "+responseEntity.getBody());
  }
}