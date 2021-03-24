String[] strArray = { "How", "To", "Do", "In", "Java" };
 
String joinedString = StringUtils.join(strArray);
System.out.println(joinedString);
 
String joinedString2 = StringUtils.join(strArray, ", ");
System.out.println(joinedString2);