public R getResourcesFromGet(final RestTemplate rt, final URI targetURI) {
    ResponseEntity<R> resp = rt.getForEntity(targetURI, getTypeClass());

    if (resp != null) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("response is not null: " + resp.getStatusCode());
        }
        if (resp.getStatusCode() == HttpStatus.OK) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("response is OK");
            }
            this.processHeaders(targetURI, resp.getHeaders());
            return resp.getBody();
        } else {
            return null;
        }
    } else {
        return null;
    }
}