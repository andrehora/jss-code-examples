private static String normalizePath(final Service service) {
    String path = service.getId();
    path = StringUtils.substringBefore(path, "?");
    path = StringUtils.substringBefore(path, ";");
    path = StringUtils.substringBefore(path, "#");
    return path;
}