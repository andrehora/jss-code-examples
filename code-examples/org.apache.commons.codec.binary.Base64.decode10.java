public static String decode(String content,String encoding) throws UnsupportedEncodingException{
    byte[] b3 = content.getBytes("UTF-8");
    Base64 base64 = new Base64();
    byte[] b4 = base64.decode(b3);
    return new String(b4,encoding);
}