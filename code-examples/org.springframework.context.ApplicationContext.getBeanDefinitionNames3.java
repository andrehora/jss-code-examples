public class HelloWorldController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="key", required=false, defaultValue="World") String name, Model model) {

        String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {

            System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
        }

        model.addAttribute("name", name);

        return "helloworld";
    }
}