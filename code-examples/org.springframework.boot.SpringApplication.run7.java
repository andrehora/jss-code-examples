@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
		BatchAutoConfiguration.class })
@EnableConfigurationProperties({ResourceResolverProperties.class, SquashPathProperties.class})
@EnableWebSecurity
@ImportResource({"classpath*:META-INF/spring/dynamicdao-context.xml", "classpath*:META-INF/spring/dynamicmanager-context.xml"})
public class SquashTm {
	private static final Logger LOGGER = LoggerFactory.getLogger(SquashTm.class);

	public static void main(String[] args) {
		new SpringApplication(SquashTm.class).run(args);
	}

}