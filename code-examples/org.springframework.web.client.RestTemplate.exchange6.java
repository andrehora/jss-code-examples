public Map<String, String> getUserInfoFor(OAuth2AccessToken accessToken) {
    RestTemplate restTemplate = new RestTemplate();

    RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(
            getHeader(accessToken),
            HttpMethod.GET,
            URI.create("https://www.googleapis.com/oauth2/v3/userinfo")
    );

    ResponseEntity<Map> result = restTemplate.exchange(
            requestEntity, Map.class);

    if (result.getStatusCode().is2xxSuccessful()) {
        return result.getBody();
    }

    throw new RuntimeException("It wasn't possible to retrieve userInfo");
}