@AfterClass
public static void shutdown() {
	if (shutdownAfterRun) {
		logger.info("Stopping Data Flow Shell");
		if (dataFlowShell != null) {
			dataFlowShell.stop();
		}
		if (applicationContext != null) {
			logger.info("Stopping Data Flow Server");
			SpringApplication.exit(applicationContext);

			applicationContext = null;
		}
	}
}