public boolean setPage(int page) {
	Preconditions.checkPositionIndex(page, messages.size());
	BakedMessage message = messages.get(page);
	if (sentMessage != null) {
         message.update(sentMessage);
	}
	this.page = page;
	this.lastUpdate = System.currentTimeMillis();
	return true;
}