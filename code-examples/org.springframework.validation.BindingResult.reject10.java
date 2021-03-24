private List<SecretFile> handleStream(final HttpServletRequest req,
                                      final KeyIv encryptionKey, final DataBinder binder)
    throws FileUploadException, IOException {

    final BindingResult errors = binder.getBindingResult();

    final MutablePropertyValues propertyValues = new MutablePropertyValues();
    final List<SecretFile> tmpFiles = new ArrayList<>();

    @SuppressWarnings("checkstyle:anoninnerlength")
    final AbstractMultipartVisitor visitor = new AbstractMultipartVisitor() {

        private OptionalInt expiration = OptionalInt.empty();

        @Override
        void emitField(final String name, final String value) {
            propertyValues.addPropertyValue(name, value);

            if ("expirationDays".equals(name)) {
                expiration = OptionalInt.of(Integer.parseInt(value));
            }
        }

        @Override
        void emitFile(final String fileName, final InputStream inStream) {
            final Integer expirationDays = expiration
                .orElseThrow(() -> new IllegalStateException("No expirationDays configured"));

            tmpFiles.add(messageService.encryptFile(fileName, inStream, encryptionKey,
                Instant.now().plus(expirationDays, ChronoUnit.DAYS)));
        }

    };

    try {
        visitor.processRequest(req);
        binder.bind(propertyValues);
        binder.validate();
    } catch (final IllegalStateException ise) {
        errors.reject(null, ise.getMessage());
    }

    return tmpFiles;
}