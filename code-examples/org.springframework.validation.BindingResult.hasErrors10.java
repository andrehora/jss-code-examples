@RequestMapping(value = "/comment/add", method = RequestMethod.POST)
public CommentDTO createComment(@Valid @RequestBody CommentDTO commentDTO, BindingResult br){
    if(br.hasErrors()){return null;}
    if(userService.getPrincipal() == null){
        CommentDTO errorDTO = new CommentDTO();
        errorDTO.setErrorAccess(true);
        return errorDTO;
    }
    User user = userService.getUserBySsoId(userService.getPrincipal(), true);
    Comment comment = new Comment(user.getName(), user.getSsoId(), commentDTO.getCommentBody());
    articleService.addComment(comment, commentDTO.getArticleID());
    Long commentID = commentService.saveComment(comment);
    return new CommentDTO(user.getName(), user.getSsoId(), commentID, commentDTO.getCommentBody(), "just now", commentDTO.getArticleID(), false);
}