private void getHistory() {
    logger.debug("getHistory start.");
    String historys = CookieUtils.getHistoryCookie(ServletActionContext.getRequest());
    if (StringUtils.isNotEmpty(historys)) {
        String[] acnos = StringUtils.split(historys, ",");
        List<String> articlenoList = new ArrayList<String>();
        for (String articleAndchapterno : acnos) {
            String[] acnoArr = StringUtils.split(articleAndchapterno, "|");
            if (acnoArr.length > 0) {
                articlenoList.add(acnoArr[0]);
            }
        }
        if (articlenoList.size() > 0) {
            ArticleSearchBean searchBean = new ArticleSearchBean();
            searchBean.setArticlenos(StringUtils.join(articlenoList, ","));
            dto.setItems(articleService.find(searchBean));
        }
        dto.setCode(ReturnCode.SUCCESS);
    }
    logger.debug("getHistory normally end.");
}