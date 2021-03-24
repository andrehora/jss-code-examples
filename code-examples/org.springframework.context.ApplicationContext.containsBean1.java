public class Teacher implements ApplicationContextAware {
     
    private ApplicationContext context;
    private List<Course> courses = new ArrayList<>();
     
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
 
    @PostConstruct
    public void addCourse() {
        if (context.containsBean("math")) {
            Course math = context.getBean("math", Course.class);
            courses.add(math);
        }
        if (context.containsBean("physics")) {
            Course physics = context.getBean("physics", Course.class);
            courses.add(physics);
        }
    }
 
    // standard constructors, getters and setters
}