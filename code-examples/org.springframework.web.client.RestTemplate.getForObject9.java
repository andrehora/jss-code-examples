private <T> T request(final String url, final Class<T> deconstructClass) {
    final RestTemplate restTemplate = new RestTemplate();
    T deconstructedResponse = null;

    try {
        deconstructedResponse = restTemplate.getForObject(url, deconstructClass);
    } catch (HttpClientErrorException err) {
        logger.info("[YoutubeReader] [request] Failure To Retrieve YouTube Resource (" + url + ")", err);
    }

    return deconstructedResponse;
}