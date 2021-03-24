private void testCodeFirstAddDate(RestTemplate template, String cseUrlPrefix) {
  Map<String, Object> body = new HashMap<>();
  Date date = new Date();
  body.put("date", date);

  int seconds = 1;
  Date result = template.postForObject(cseUrlPrefix + "addDate?seconds={seconds}",
      body,
      Date.class,
      seconds);
  TestMgr.check(new Date(date.getTime() + seconds * 1000), result);
}