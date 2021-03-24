private String encodeUrlSafeBase64(byte[] input) {
        return Base64.encodeBase64URLSafeString(input);
}