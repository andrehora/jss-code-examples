@RequestMapping(value = "/rssfeed", method = RequestMethod.GET)
public ModelAndView getFeedInRss() {
    List<RssBatchStatus> items = new ArrayList<RssBatchStatus>();
    List<BatchInstanceStatus> statusList = new ArrayList<BatchInstanceStatus>();
    statusList.add(BatchInstanceStatus.READY_FOR_REVIEW);
    statusList.add(BatchInstanceStatus.READY_FOR_VALIDATION);
    List<BatchInstance> batchInstances = batchInstanceService.getBatchInstanceByStatusList(statusList);
    for (BatchInstance batchInstance : batchInstances) {
        RssBatchStatus status = new RssBatchStatus(batchInstance);
        items.add(status);
    }
    ModelAndView mav = new ModelAndView();
    mav.setViewName("rssViewer");
    mav.addObject("feedContent", items);
    return mav;
}