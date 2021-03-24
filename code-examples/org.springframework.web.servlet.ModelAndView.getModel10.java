protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response,Object o,BindException e) throws Exception {
  ModelAndView mav=super.handle(request,response,o,e);
  Long pageID=ServletRequestUtils.getLongParameter(request,"referencePage",0);
  Page page=pageService.getEntity(pageID);
  mav.getModel().put("referencePage",page);
  return mav;
}