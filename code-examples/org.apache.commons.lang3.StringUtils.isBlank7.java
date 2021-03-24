private String getRemoteIp(@NotNull final RequestContext context) {
    final HttpServletRequest request = WebUtils.getHttpServletRequest(context);
    String userAddress = request.getRemoteAddr();
    logger.debug("Remote Address = {}", userAddress);

    if (StringUtils.isNotBlank(this.alternativeRemoteHostAttribute)) {

        userAddress = request.getHeader(this.alternativeRemoteHostAttribute);
        logger.debug("Header Attribute [{}] = [{}]", this.alternativeRemoteHostAttribute, userAddress);

        if (StringUtils.isBlank(userAddress)) {
            userAddress = request.getRemoteAddr();
            logger.warn("No value could be retrieved from the header [{}]. Falling back to [{}].",
                    this.alternativeRemoteHostAttribute, userAddress);
        }
    }
    return userAddress;
}