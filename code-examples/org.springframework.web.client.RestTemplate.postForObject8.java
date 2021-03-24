private void testCodeFirstUserMap(RestTemplate template, String cseUrlPrefix) {
  User user1 = new User();
  user1.setNames(new String[] {"u1", "u2"});

  User user2 = new User();
  user2.setNames(new String[] {"u3", "u4"});

  Map<String, User> userMap = new HashMap<>();
  userMap.put("u1", user1);
  userMap.put("u2", user2);

  @SuppressWarnings("unchecked")
  Map<String, User> result = template.postForObject(cseUrlPrefix + "testUserMap",
      userMap,
      Map.class);

  TestMgr.check("u1", result.get("u1").getNames()[0]);
  TestMgr.check("u2", result.get("u1").getNames()[1]);
  TestMgr.check("u3", result.get("u2").getNames()[0]);
  TestMgr.check("u4", result.get("u2").getNames()[1]);
}