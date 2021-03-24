public String getMarathonServiceDetails() {
    try {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(props.getMarathon().getUrl() + "/v2/apps", HttpMethod.GET, null, String.class);

        if (responseEntity.getStatusCode().value() != 200) {
            LOG.error("error marathon service failed with status code " + responseEntity.getStatusCode().value());
            return null;
        }
        isHealthy = true;
        if (LOG.isTraceEnabled()) {
            LOG.trace("marathon services details: " + responseEntity.getBody());
        }
        return responseEntity.getBody();
    } catch (RestClientException e) {
        LOG.error("error in calling marathon service details: ", e);
        isHealthy = false;
        return null;
    }
}