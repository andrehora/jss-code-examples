protected List<JsonRole> getResourcesFromGet(final RestTemplate rt, final URI targetURI)
        throws HttpStatusCodeException, UpdaterHttpException {
    ResponseEntity<JsonRoles> resp = rt.getForEntity(targetURI, JsonRoles.class);
    if (resp != null) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("response is not null: " + resp.getStatusCode());
        }
        if (resp.getStatusCode() == HttpStatus.OK) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("response is OK");
            }
            return resp.getBody().getRoles();
        } else {
            throw new UpdaterHttpException(
                    "unable to collect roles - status code: " + resp.getStatusCode().toString());
        }
    } else {
        throw new UpdaterHttpException("unable to collect roles - HTTP response was null");
    }
}