public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	boolean hasBean=applicationContext.containsBean(KnowledgePackageService.BEAN_ID);
	if(hasBean){
		knowledgePackageService=(KnowledgePackageService)applicationContext.getBean(KnowledgePackageService.BEAN_ID);		
	}
}