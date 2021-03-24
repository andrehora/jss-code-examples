@RequestMapping("adicionaTarefa")
public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

	if(result.hasFieldErrors("descricao")) {
		return "tarefa/formulario";
	}

	JdbcTarefaDao dao = new JdbcTarefaDao();
	dao.adiciona(tarefa);
	return "tarefa/adicionada";
}