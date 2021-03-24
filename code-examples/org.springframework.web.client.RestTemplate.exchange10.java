public GitHubEmail getPrimaryEmail(final String gitHubToken) {
    RestTemplate template = new GitHubRestTemplate(gitHubToken);
    ResponseEntity<List<GitHubEmail>> response = template.exchange(GITHUB_EMAIL_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<GitHubEmail>>(){});
    List<GitHubEmail> emails = response.getBody();
    GitHubEmail primary = emails.stream().filter(e -> e.isPrimary()).findFirst().get();
    return primary;
}