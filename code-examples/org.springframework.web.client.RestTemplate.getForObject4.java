@RequestMapping(value= "/fetchjson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public Person getForObjectJsonDemo(@PathVariable(value = "id") Integer id) {
	Address address = new Address("Dhananjaypur","Varanasi", "UP");
	return new Person(id,"Ram", address);
}