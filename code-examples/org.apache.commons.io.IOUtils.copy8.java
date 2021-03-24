public void getAuthorizedPhoto(@PathVariable String eppn, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	List<Card> validCards = Card.findCardsByEppnAndEtatNotEquals(eppn, Etat.REJECTED, "dateEtat", "desc").getResultList();
	if(!validCards.isEmpty()) {
		Card card = validCards.get(0);
		User user = User.findUser(eppn);
		if(user.getDifPhoto()) {
			PhotoFile photoFile = card.getPhotoFile();
			Long size = photoFile.getFileSize();
			String contentType = photoFile.getContentType();
			response.setContentType(contentType);
			response.setContentLength(size.intValue());
			IOUtils.copy(photoFile.getBigFile().getBinaryFile().getBinaryStream(), response.getOutputStream());
		}else{
			ClassPathResource noImg = new ClassPathResource(ManagerCardController.IMG_INTERDIT);
			IOUtils.copy(noImg.getInputStream(), response.getOutputStream());
		}
	}
}