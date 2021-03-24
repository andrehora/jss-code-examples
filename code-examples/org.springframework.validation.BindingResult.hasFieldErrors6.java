@RequestMapping(value = "/produto/salvarProduto", method = RequestMethod.POST)
public String salvarProduto(@Valid Produto produto, BindingResult result, ModelMap model) {
    String mensagem = null;
    if (result.hasFieldErrors("nome") || result.hasFieldErrors("descricao") || result.hasFieldErrors("preco")) {
        mensagem = mensagensPadronizadas.erroAoCadastrarProduto;
        model.addAttribute("mensagemTitulo", mensagem);
        return "forward:/produto";
    } else {
        try {
            produtoService.salvarProduto(produto);
            mensagem = mensagensPadronizadas.produtoAdicionadoComSucesso;
        } catch (ValidationException e) {
            mensagem = e.getMessage();
        }
        model.addAttribute("mensagemTitulo", mensagem);
        return "forward:/produto";
    }
}