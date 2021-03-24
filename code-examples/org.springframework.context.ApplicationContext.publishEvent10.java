public void buttonClick(Button.ClickEvent event) {
	applicationContext.publishEvent(new ApplicationEvent("Hello World from ApplicationContext") {

		private static final long serialVersionUID = -3039286026590540225L;

		@Override
		public Object getSource() {
			return EventBusUI.this;
		}
	});
}