public static boolean isServerListening(final URI url) {
    RestTemplate restTemplate = new RestTemplate();
    try {
        restTemplate.getForObject(url, String.class);
    } catch (RestClientException e) {
        if (e.getCause() instanceof ConnectException) {
            return false;
        }
    }
    return true;
}