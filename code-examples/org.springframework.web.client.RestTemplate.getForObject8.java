public DataFlowTemplate(URI baseURI, RestTemplate restTemplate) {

	Assert.notNull(baseURI, "The provided baseURI must not be null.");
	Assert.notNull(restTemplate, "The provided restTemplate must not be null.");

	this.restTemplate = prepareRestTemplate(restTemplate);
	final ResourceSupport resourceSupport = restTemplate.getForObject(baseURI, ResourceSupport.class);
	this.runtimeOperations = new RuntimeTemplate(restTemplate, resourceSupport);
	this.appRegistryOperations = new AppRegistryTemplate(restTemplate, resourceSupport);
	this.completionOperations = new CompletionTemplate(restTemplate,
		resourceSupport.getLink("completions/stream"),
		resourceSupport.getLink("completions/task"));
	if (resourceSupport.hasLink(ApplicationTemplate.DEFINITIONS_REL)) {
		this.applicationOperations = new ApplicationTemplate(restTemplate, resourceSupport);
	}
	else {
		this.applicationOperations = null;
	}
}