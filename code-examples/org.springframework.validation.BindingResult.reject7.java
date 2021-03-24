private void doValidate() throws BindException {
	BindingResult errors = new BeanPropertyBindingResult(this,
			"resourceServerProperties");
	boolean jwtConfigPresent = StringUtils.hasText(this.jwt.getKeyUri())
			|| StringUtils.hasText(this.jwt.getKeyValue());
	boolean jwkConfigPresent = StringUtils.hasText(this.jwk.getKeySetUri());
	if (jwtConfigPresent && jwkConfigPresent) {
		errors.reject("ambiguous.keyUri",
				"Only one of jwt.keyUri (or jwt.keyValue) and jwk.keySetUri should"
						+ " be configured.");
	}
	if (!jwtConfigPresent && !jwkConfigPresent) {
		if (!StringUtils.hasText(this.userInfoUri)
				&& !StringUtils.hasText(this.tokenInfoUri)) {
			errors.rejectValue("tokenInfoUri", "missing.tokenInfoUri",
					"Missing tokenInfoUri and userInfoUri and there is no "
							+ "JWT verifier key");
		}
		if (StringUtils.hasText(this.tokenInfoUri) && isPreferTokenInfo()) {
			if (!StringUtils.hasText(this.clientSecret)) {
				errors.rejectValue("clientSecret", "missing.clientSecret",
						"Missing client secret");
			}
		}
	}
	if (errors.hasErrors()) {
		throw new BindException(errors);
	}
}