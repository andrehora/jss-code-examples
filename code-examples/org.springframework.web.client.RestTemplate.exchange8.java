public static CompositeAccessToken getAccessAndRefreshToken(String oauthEndpoint, String code, DashboardClient dashboardClient,
                                                      String redirectUri) throws RestClientException {
    String clientBasicAuth = getClientBasicAuthHeader(dashboardClient.getId(),  dashboardClient.getSecret());
    RestTemplate template = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.AUTHORIZATION, clientBasicAuth);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    MultiValueMap<String,String> form = new LinkedMultiValueMap<>();
    form.add("response_type", "token");
    form.add("grant_type", "authorization_code");
    form.add("client_id", dashboardClient.getId());
    form.add("client_secret", dashboardClient.getSecret());
    form.add("redirect_uri", redirectUri);
    form.add("code", code);

    ResponseEntity<CompositeAccessToken> token = template.exchange(oauthEndpoint + "/token",
            HttpMethod.POST, new HttpEntity<>(form, headers), CompositeAccessToken.class);

    if (token != null)
        return token.getBody();
    else
        return null;
}