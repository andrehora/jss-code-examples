@GetMapping(value = "/{pagename}")
public String page(@PathVariable String pagename, HttpServletRequest request) {
    ContentVo contents = contentService.getContents(pagename);
    if (null == contents) {
        return this.render_404();
    }
    if (contents.getAllowComment()) {
        String cp = request.getParameter("cp");
        if (StringUtils.isBlank(cp)) {
            cp = "1";
        }
        PageInfo<CommentBo> commentsPaginator = commentService.getComments(contents.getCid(), Integer.parseInt(cp), 6);
        request.setAttribute("comments", commentsPaginator);
    }
    request.setAttribute("article", contents);
    updateArticleHit(contents.getCid(), contents.getHits());
    return this.render("page");
}