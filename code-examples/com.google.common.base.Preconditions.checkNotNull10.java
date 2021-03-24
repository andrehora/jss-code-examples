public static final String join(final String... parts) {
  final StringBuilder sb = new StringBuilder();
  for (final String part:parts) {
    Preconditions.checkNotNull(part, "parts cannot contain null");
    if (!Strings.isNullOrEmpty(part)) {
      sb.append(part).append("/");
    }
  }
  if (sb.length() > 0) {
    sb.deleteCharAt(sb.length() - 1);
  }
  final String path = sb.toString();
  return normalize(path);
}