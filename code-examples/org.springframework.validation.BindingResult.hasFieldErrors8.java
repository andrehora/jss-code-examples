@Transactional
@RequestMapping("/save/{action}")
public ModelAndView save(@PathVariable String action, @Valid Curso curso, BindingResult bind) {
    Message msg = null;
    if (bind.hasFieldErrors()) {
        msg = new Message(MessageType.ERROR, "Curso informado Ã© invÃ¡lido para esta operaÃ§Ã£o!");
    } else if ("add".equals(action)) {
        cursoJpaDAO.create(curso);
        msg = new Message(MessageType.INFO, "Curso incluido com sucesso!");
    } else if ("edit".equals(action)) {
        cursoJpaDAO.update(curso);
        msg = new Message(MessageType.INFO, "Curso alterado com sucesso!");
    } else if ("delete".equals(action)) {
        cursoJpaDAO.delete(curso);
        msg = new Message(MessageType.INFO, "Curso excluido com sucesso!");
    } else {
        msg = new Message(MessageType.ERROR, "OperaÃ§Ã£o InvÃ¡lida!");
    }
    ModelAndView mv = new ModelAndView("common/message");
    mv.addObject("msg", msg);
    mv.addObject("back", "/cursos/list");
    return mv;
}