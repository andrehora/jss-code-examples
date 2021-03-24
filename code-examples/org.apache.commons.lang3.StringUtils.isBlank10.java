public void processCommentsForPageUpdate(final JSONObject page) throws Exception {
	final String pageId = page.getString(Keys.OBJECT_ID);

	final List<JSONObject> comments = commentDao.getComments(pageId, 1, Integer.MAX_VALUE);

	for (final JSONObject comment : comments) {
		final String commentId = comment.getString(Keys.OBJECT_ID);
		final String sharpURL = Comments.getCommentSharpURLForPage(page, commentId);

		comment.put(Comment.COMMENT_SHARP_URL, sharpURL);

		if (StringUtils.isBlank(comment.optString(Comment.COMMENT_ORIGINAL_COMMENT_ID))) {
			comment.put(Comment.COMMENT_ORIGINAL_COMMENT_ID, "");
		}
		if (StringUtils.isBlank(comment.optString(Comment.COMMENT_ORIGINAL_COMMENT_NAME))) {
			comment.put(Comment.COMMENT_ORIGINAL_COMMENT_NAME, "");
		}

		commentDao.update(commentId, comment);
	}
}