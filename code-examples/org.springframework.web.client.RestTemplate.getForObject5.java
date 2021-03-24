public class GetForObjectDemoWithJSON {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject("http://localhost:8080/spring-rest/data/fetchjson/{id}", Person.class, 200);
        System.out.println("ID: " + person.getId());
        System.out.println("Name: " + person.getName());
        System.out.println("Village Name: " + person.getAddress().getVillage());
    }
}