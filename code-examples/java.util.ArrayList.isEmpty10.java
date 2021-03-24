public boolean refreshList() throws DataSourceException {
    ArrayList<Produto> result = ServicoProduto.procurarProduto(ultimaPesquisa);        

    DefaultTableModel model = (DefaultTableModel) jtConsultar.getModel();

    model.setRowCount(0);
    
    if (result == null || result.isEmpty()) {
        return false;
    }

    for (int i = 0; i < result.size(); i++) {
        Produto p = result.get(i);
        if (p != null) {
            Object[] row = new Object[6];
            row[0] = p.getId();
            row[1] = p.getNome();
            row[2] = p.getCategoria();
            row[3] = p.getValorCompra();
            row[4] = p.getValorVenda();
            row[5] = p.getDtCadastro();
            model.addRow(row);
        }
    }
    return true;
}