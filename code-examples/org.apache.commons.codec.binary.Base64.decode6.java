public void testEncode(){
    String message = "abcd";
    byte[] b=message.getBytes();
    Base64 base64=new Base64();
    byte[] b2 = base64.encode(b);
    String s=new String(b2);
    System.out.println(s);

    byte[] b3 = s.getBytes();
    byte[] b4 = base64.decode(b3);
    String s2=new String(b4);
    System.out.println(s2);

    Assert.assertTrue( message.equals(s2) );
}