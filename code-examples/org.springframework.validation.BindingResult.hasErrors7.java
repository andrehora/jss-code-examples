@RequestMapping(value = "/categories/new", method = RequestMethod.POST)
public String addCategory(@Valid CategoryDTO categoryDTO,
                          BindingResult result,
                          SessionStatus status,
                          RedirectAttributes attributes) {
    if (result.hasErrors()) {
        return ADMIN_CATEGORIES_VIEW;
    } else {

        Category category = postService.createCategory(categoryDTO);
        logger.info("Category Added: {}", category.getCategoryValue());
        status.setComplete();

        webUI.addFeedbackMessage(attributes, FEEDBACK_MESSAGE_CATEGORY_ADDED, category.getCategoryValue());
        return "redirect:/admin/posts/categories";
    }
}