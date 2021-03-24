private Optional<Integer> configureErrorRetryCount(String property) {
    Integer count = null;
    if (null != property) {
        count = Ints.tryParse(property);
        if (null == count || count < 0) {
            throw new IllegalArgumentException("System property [" + S3_MAX_ERROR_RETRY + "=" + property + "]  must be a valid positive Integer");

        }
    }
    return Optional.fromNullable(count);
}