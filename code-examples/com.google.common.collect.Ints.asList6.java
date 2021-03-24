static void deletecols(JTable table, int[] exp) {
    Integer[] selcols;
    try {
        TableColumnModel tcm = table.getColumnModel();
        selcols = ArrayUtils.toObject(table.getSelectedColumns());
        Arrays.sort(selcols, Collections.reverseOrder());
        List<Integer> explist = Ints.asList(exp);
        for (int i : selcols) {
            if (!explist.contains(i)) {
                tcm.removeColumn(tcm.getColumn(i));
            }
        }

    } catch (Exception e) {
        Logger.getLogger(JtableUtils.class.getName()).log(Level.SEVERE, null, e);
    }

}