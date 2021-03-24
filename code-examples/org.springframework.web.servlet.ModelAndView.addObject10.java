@RequestMapping(value = "/newPost", method = RequestMethod.GET)
public ModelAndView newPost(Principal principal) {
    ModelAndView modelAndView = new ModelAndView();
    User user = userService.findByUsername(principal.getName());
    Post post = new Post();
    post.setUser(user);
    modelAndView.addObject("post", post);
    modelAndView.setViewName("postForm");
    return modelAndView;
}