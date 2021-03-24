@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config-hello.xml"})
public class HelloIT {

    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void testPublishEvent() {
        applicationContext.publishEvent(new ContentEvent("This year is the year of the Dragon blog update"));
    }

}