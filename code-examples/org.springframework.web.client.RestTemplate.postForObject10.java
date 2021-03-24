public UserInfo loadUserInfo(OIDCAuthenticationToken token){
  HttpClient httpClient=new DefaultHttpClient();
  HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory(httpClient);
  RestTemplate restTemplate=new RestTemplate(factory);
  MultiValueMap<String,String> form=new LinkedMultiValueMap<String,String>();
  form.add("access_token",token.getAccessTokenValue());
  form.add("schema","openid");
  String userInfoString=restTemplate.postForObject(token.getServerConfiguration().getUserInfoUrl(),form,String.class);
  JsonObject userInfoJson=new JsonParser().parse(userInfoString).getAsJsonObject();
  UserInfo userInfo=DefaultUserInfo.fromJson(userInfoJson);
  return userInfo;
}