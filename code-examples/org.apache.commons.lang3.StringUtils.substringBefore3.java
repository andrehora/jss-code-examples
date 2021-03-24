assertEquals("the USA (United States of America).", 
  StringUtils.substringAfter(text, "living in "));
assertEquals("Julia Evans", 
  StringUtils.substringBefore(text, " was born"));