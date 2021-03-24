@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping
    public List<TodoModel> getTodos() {
        String theUrl = "https://jsonplaceholder.typicode.com/todos";
        ResponseEntity<List<TodoModel>> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<TodoModel>>() {
        });
        List<TodoModel> todoList = response.getBody();
        return todoList;
    }
}