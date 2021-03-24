protected List<JsonDomain> getResourcesFromGet(final RestTemplate rt, final URI targetURI)
        throws HttpStatusCodeException, UpdaterHttpException {
    ResponseEntity<JsonDomains> resp = rt.getForEntity(targetURI, JsonDomains.class);
    if (resp != null) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("response is not null: " + resp.getStatusCode());
        }
        if (resp.getStatusCode() == HttpStatus.OK) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("response is OK");
            }
            return resp.getBody().getDomains();
        } else {
            throw new UpdaterHttpException(
                    "unable to collect domains - status code: " + resp.getStatusCode().toString());
        }
    } else {
        throw new UpdaterHttpException("unable to collect domains - HTTP response was null");
    }
}