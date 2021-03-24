PostMapping("/create")
public String createUser(@Valid CreateUserForm form,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
        redirectAttributes.addFlashAttribute("flashMessage", "admin.users.create.error." + bindingResult.getFieldError().getField());

        return "redirect:/admin/users";
    }
    boolean error = false;
    try{
    	userCreationService.create(form.toUisUser());
    }catch(ValidationException e){
    	error = true;
        redirectAttributes.addFlashAttribute("flashMessage", "admin.users.create.error.email");
    }
    if(!error){
    	redirectAttributes.addFlashAttribute("flashMessage", "admin.users.create.success");
    }
    
    return "redirect:/admin/users";
}