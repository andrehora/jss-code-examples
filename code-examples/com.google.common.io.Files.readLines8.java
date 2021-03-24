public final void loadHistory() {
	try {
		final File history = new File(Utils.getParentFolder(), Constants.FILE_GUI_HISTORY);
		if(!history.exists()) {
			return;
		}
		for(final String path : Files.readLines(history, StandardCharsets.UTF_8)) {
			final File projectData = new File(path, Constants.FILE_PROJECT_DATA);
			if(!projectData.exists()) {
				continue;
			}
			projectsModel.addElement(path);
		}
	}
	catch(final Exception ex) {
		ex.printStackTrace(guiPrintStream);
		ex.printStackTrace();
		JOptionPane.showMessageDialog(ProjectsFrame.this, String.format(Constants.GUI_DIALOG_ERROR_MESSAGE, ex.getMessage()), ex.getClass().getName(), JOptionPane.ERROR_MESSAGE);
	}
}