public void cancelDelegationToken(URL url, Token token, String doAsUser)
    throws IOException {
  Preconditions.checkNotNull(url, "url");
  Preconditions.checkNotNull(token, "token");
  Preconditions.checkNotNull(token.delegationToken,
      "No delegation token available");
  try {
    ((KerberosDelegationTokenAuthenticator) getAuthenticator()).
        cancelDelegationToken(url, token, token.delegationToken, doAsUser);
  } finally {
    token.delegationToken = null;
  }
}