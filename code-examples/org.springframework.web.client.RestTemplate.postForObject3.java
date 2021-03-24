public class PostForObjectDemo {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/spring-rest/data/saveinfo/{id}/{name}";
        Map>String, String> map = new HashMap<String, String>();
        map.put("id", "111");
        map.put("name", "Shyam");
	Address address = new Address("Dhananjaypur", "Varanasi", "UP");
        Person person= restTemplate.postForObject(url, address, Person.class, map);
        System.out.println(person.getName());
        System.out.println(person.getAddress().getVillage());
    }
}