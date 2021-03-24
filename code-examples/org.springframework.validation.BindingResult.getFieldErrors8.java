@RequestMapping(value = "/list", method = RequestMethod.POST)
public String addList(Principal principal, @Valid @ModelAttribute("newList") ShoppingListDTO newList, BindingResult binding, RedirectAttributes attr, HttpSession session) {
	LOGGER.debug("addList() method of MvcController called for user: {}", principal.getName());
	if(!binding.hasErrors()) 
		repositoryService.addShoppingListToUserByName(principal.getName(), newList.getListName());
	else {
		attr.addFlashAttribute("org.springframework.validation.BindingResult.newList", binding);
		attr.addFlashAttribute("newList", newList);
		for(FieldError ferr:binding.getFieldErrors()) {
			LOGGER.info("addList(): field error: " + ferr.getDefaultMessage());
		}
	}
	
	return "redirect:/list";
}