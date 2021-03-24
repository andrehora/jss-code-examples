public String addSpitterFromForm(@Valid JobDesc jobDesc,BindingResult bindingResult){
	if(bindingResult.hasErrors()){
		return"login/hello";
	}
	try{
		jobDesc.setJobName(new String(jobDesc.getJobName().getBytes("iso-8859-1"),"utf-8"));
		jobDesc.setJobGroup(new String(jobDesc.getJobGroup().getBytes("iso-8859-1"),"utf-8"));
		jobDesc.setTrigName(new String(jobDesc.getTrigName().getBytes("iso-8859-1"),"utf-8"));
		jobDesc.setTrigGroup(new String(jobDesc.getTrigGroup().getBytes("iso-8859-1"),"utf-8"));
		jobMgrService.addSche(jobDesc);
	}catch(Exception e){
		bindingResult.reject(e.getMessage());
		return"login/hello";
	}
	return "redirect:/quartz/login?jobName="+jobDesc.getJobName()+"&jobGroup="+jobDesc.getJobGroup();
}