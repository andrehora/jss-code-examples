@RequestMapping(value = "/add/link", method = POST)
public String createLinkPost(@Valid PostDTO postDTO, BindingResult result,
                             CurrentUser currentUser, RedirectAttributes attributes, Model model,
                             HttpServletRequest request) throws DuplicatePostNameException {
    PagePreviewDTO pagePreview =
            (PagePreviewDTO) WebUtils.getSessionAttribute(request, "pagePreview");

    model.addAttribute("postheader", webUI.getMessage(ADD_LINK_HEADER));
    model.addAttribute("postFormType", "link");

    if (!isDuplicatePost(postDTO, null)) {
        if (result.hasErrors()) {
            model.addAttribute("hasLink", true);
            model.addAttribute("hasCarousel", true);
            model.addAttribute("pagePreview", pagePreview);
            if (result.hasFieldErrors("postTitle")) {
                postDTO.setPostTitle(pagePreview.getTitle());
            }
            model.addAttribute("postDTO", postDTO);
            return ADMIN_LINK_ADD_VIEW;
        } else {

            if (postDTO.getHasImages()) {
                if (postDTO.getDisplayType() != PostDisplayType.LINK) {
                    postDTO.setPostImage(
                            pagePreview.getImages().get(postDTO.getImageIndex()).src);
                } else
                    postDTO.setPostImage(null);
            }

            postDTO.setPostSource(PostUtils.createPostSource(postDTO.getPostLink()));
            postDTO.setPostName(PostUtils.createSlug(postDTO.getPostTitle()));
            postDTO.setUserId(currentUser.getId());
            postDTO.setPostContent(cleanContentTailHtml(postDTO.getPostContent()));

            request.setAttribute("postTitle", postDTO.getPostTitle());
            Post post = postService.add(postDTO);

            postDTO.setPostId(post.getPostId());
            post.setPostMeta(jsoupService.createPostMeta(postDTO));

            // All links are saved as PUBLISHED so no _isPublished_ status check on new Links
            if (applicationSettings.getSolrEnabled())
                postDocService.addToIndex(post);

            // Links are included in Posts A-to-Z Listing
            fmService.createPostAtoZs();

            webUI.addFeedbackMessage(attributes, FEEDBACK_POST_LINK_ADDED);
            return "redirect:/admin/posts";
        }
    } else {
        result.reject("global.error.post.name.exists", new Object[]{postDTO.getPostTitle()}, "post name exists");
        model.addAttribute("hasLink", true);
        model.addAttribute("hasCarousel", true);
        model.addAttribute("pagePreview", pagePreview);
        return ADMIN_LINK_ADD_VIEW;
    }
}