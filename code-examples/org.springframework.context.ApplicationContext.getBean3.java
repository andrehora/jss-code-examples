public class HelloWorld {

	public String getValueFromContext(String beanName) {
		ApplicationContext appCtx = ApplicationContextUtils
				.getApplicationContext();
		String strFromContext = (String) appCtx.getBean(beanName);
		return strFromContext;
	}
}