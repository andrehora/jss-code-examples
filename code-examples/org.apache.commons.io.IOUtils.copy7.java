private OpenPgpDataSink<MimeBodyPart> getDataSinkForOpenPgpDecryptedInlineData() {
    return new OpenPgpDataSink<MimeBodyPart>() {
        @Override
        public MimeBodyPart processData(InputStream is) throws IOException {
            try {
                ByteArrayOutputStream decryptedByteOutputStream = new ByteArrayOutputStream();
                IOUtils.copy(is, decryptedByteOutputStream);
                TextBody body = new TextBody(new String(decryptedByteOutputStream.toByteArray()));
                return new MimeBodyPart(body, "text/plain");
            } catch (MessagingException e) {
                Timber.e(e, "MessagingException");
            }

            return null;
        }
    };
}