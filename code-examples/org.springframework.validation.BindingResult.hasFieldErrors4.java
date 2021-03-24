@RequestMapping(value = "/confirmarCadastro", method = RequestMethod.POST)
public String confirmarCadastro(@Valid Contato contato, BindingResult bindingResult, 
		RedirectAttributes redirectAttributes) {        

	if (bindingResult.hasFieldErrors()) {
		return "contatos/cadastro";
	}

	contatoService.save(contato);
	redirectAttributes.addFlashAttribute("mensagem", "Contato cadastrado com sucesso.");
	return "redirect:/contatos";
}