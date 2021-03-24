public void string_base64_encoding_apache() {

    String levelUpLunchURL = "http://leveluplunch.com/examples/?parm=This parameter";

    String encodedURL = Base64.encodeBase64URLSafeString(levelUpLunchURL
            .getBytes());

    assertEquals(
            "aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI",
            encodedURL);
}