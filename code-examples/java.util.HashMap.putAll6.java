public Promise<Result> searchAuditHistory() {
  try {
    JsonNode requestData = request().body().asJson();
    ProjectLogger.log("Request for Search Audit History: " + requestData, LoggerEnum.INFO.name());
    Request reqObj = (Request) mapper.RequestMapper.mapRequest(requestData, Request.class);
    reqObj.setOperation(ActorOperations.SEARCH_AUDIT_LOG.getValue());
    reqObj.setRequestId(ExecutionContext.getRequestId());
    reqObj.setEnv(getEnvironment());
    HashMap<String, Object> innerMap = new HashMap<>();
    innerMap.put(JsonKey.REQUESTED_BY, ctx().flash().get(JsonKey.USER_ID));
    innerMap.putAll(reqObj.getRequest());
    reqObj.setRequest(innerMap);
    return actorResponseHandler(getActorRef(), reqObj, timeout, null, request());
  } catch (Exception e) {
    return Promise.<Result>pure(createCommonExceptionResponse(e, request()));
  }
}