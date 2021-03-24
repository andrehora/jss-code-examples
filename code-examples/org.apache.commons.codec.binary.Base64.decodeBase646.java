public ConsulRouterResp lookupRouterMessage(String serviceName, long lastConsulIndex) {
    QueryParams queryParams = new QueryParams(ConsulConstants.CONSUL_BLOCK_TIME_SECONDS, lastConsulIndex);
    Response<GetValue> orgResponse = client.getKVValue(serviceName, queryParams);
    GetValue getValue = orgResponse.getValue();
    if (getValue != null && StringUtils.isNoneBlank(getValue.getValue())) {
        String router = new String(Base64.decodeBase64(getValue.getValue()));
        ConsulRouterResp response = ConsulRouterResp.newResponse()//
                                                    .withValue(router)//
                                                    .withConsulIndex(orgResponse.getConsulIndex())//
                                                    .withConsulLastContact(orgResponse.getConsulLastContact())//
                                                    .withConsulKnowLeader(orgResponse.isConsulKnownLeader())//
                                                    .build();
        return response;
    }
    return null;
}