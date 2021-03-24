public boolean isValid(final String value, final ConstraintValidatorContext context) {
    try {
        if (StringUtils.isEmpty(value)) {
            return true; // do not validate empty value there are other constraints for that e.g. @NotNull, @Size etc...
        }

        final Path path = Paths.get(value);

        if (checkIfExists && !path.toFile().exists()) {
            return false;
        }

        final String fileExt = FilenameUtils.getExtension(value);
        return allowableFileExtensions.isEmpty() ||
               !allowableFileExtensions.stream().filter(fileExt::equalsIgnoreCase).findFirst().orElse(StringUtils.EMPTY).isEmpty();

    } catch (final InvalidPathException e) {
        LOGGER.error(e.getMessage(), e);
        return false;
    }
}