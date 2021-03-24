public void save() {
    String text = getTextField().getText();
    Integer value = Ints.tryParse(text);
    if (value == null) {
        getOption().resetToDefault();
        load();
    } else {
        getOption().set(value);
    }
}