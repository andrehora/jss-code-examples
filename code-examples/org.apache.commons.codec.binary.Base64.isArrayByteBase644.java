public void testIsUrlSafe() {
        Base64 base64Standard = new Base64(false);
        Base64 base64URLSafe = new Base64(true);

        assertFalse("Base64.isUrlSafe=false", base64Standard.isUrlSafe());
        assertTrue("Base64.isUrlSafe=true", base64URLSafe.isUrlSafe());

        byte[] whiteSpace = {' ', '\n', '\r', '\t'};
        assertTrue("Base64.isArrayByteBase64(whiteSpace)=true", Base64.isArrayByteBase64(whiteSpace));
}