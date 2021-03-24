@Controller
public class TestController {
  @Autowired
  private ApplicationContext context;
   
  @RequestMapping(value = "/testEvent")
  public String testEvent() {
    long start = System.currentTimeMillis();
    context.publishEvent(new SampleCustomEvent(context));
    long end = System.currentTimeMillis();
    int testTime = (int)((end - start) / 1000);
    ((TimeExecutorHolder) context.getBean("timeExecutorHolder")).addNewTime("testController", new Integer(testTime));
    return "success";
  }
 
  @RequestMapping(value = "/testOtherEvent")
  public String testOtherEvent() {
    context.publishEvent(new OtherCustomEvent(context));
    return "success";
  }
}