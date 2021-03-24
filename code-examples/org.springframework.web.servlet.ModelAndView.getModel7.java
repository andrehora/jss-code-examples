protected ModelAndView doGet(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse) {
    ModelAndView modelAndView = new ModelAndView(myPluginDescriptor.getPluginResourcesPath("editProfile.jsp"));
    Map<String, Object> model = modelAndView.getModel();
    model.put("testConnectionUrl", myPath + "?testConnection=true");
    model.put("namespaceChooserUrl", myKubeNamespaceChooserController.getUrl());
    model.put("deploymentChooserUrl", myKubeDeploymentChooserController.getUrl());
    model.put("deleteImageUrl", myKubeDeleteImageDialogController.getUrl());
    final String projectId = httpServletRequest.getParameter("projectId");

    final List<AgentPool> pools = new ArrayList<>();
    if (!BuildProject.ROOT_PROJECT_ID.equals(projectId)){
        pools.add(AgentPoolUtil.DUMMY_PROJECT_POOL);
    }
    pools.addAll(myAgentPoolManager.getProjectOwnedAgentPools(projectId));

    model.put("agentPools", pools);
    model.put("authStrategies", myAuthStrategyProvider.getAll());
    model.put("podTemplateProviders", myPodTemplateProviders.getAll());
    return modelAndView;
}