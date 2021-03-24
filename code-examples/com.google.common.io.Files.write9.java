public final void saveHistory() {
	try {
		final StringBuilder builder = new StringBuilder();
		for(int i = 0; i < projectsModel.size(); i++) {
			builder.append(projectsModel.getElementAt(i) + System.lineSeparator());
		}
		Files.write(builder.toString(), new File(Utils.getParentFolder(), Constants.FILE_GUI_HISTORY), StandardCharsets.UTF_8);
	}
	catch(final Exception ex) {
		ex.printStackTrace(guiPrintStream);
		ex.printStackTrace();
		JOptionPane.showMessageDialog(ProjectsFrame.this, String.format(Constants.GUI_DIALOG_ERROR_MESSAGE, ex.getMessage()), ex.getClass().getName(), JOptionPane.ERROR_MESSAGE);
	}
}