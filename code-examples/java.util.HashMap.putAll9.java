public HashMap<String, Object> getDados() {
    HashMap<String, Object> mapLista = new HashMap<>();
    ResultSet rs = Call.selectFrom("VER_AMORTIZACAO where \"ID PRESTACAO\" = ?", "*", numPrestacao);
    Consumer<HashMap<String, Object>> act = (map) -> {
        mapLista.putAll(map);
    };
    Call.forEchaResultSet(act, rs);
    return mapLista;
}