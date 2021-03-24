public static String getClassName(String code) {
    String className = StringUtils.substringBefore(code, "{");
    if (StringUtils.isBlank(className)) {
        return className;
    }
    if (StringUtils.contains(code, " class ")) {
        className = StringUtils.substringAfter(className, " class ");
        if (StringUtils.contains(className, " extends ")) {
            className = StringUtils.substringBefore(className, " extends ").trim();
        } else if (StringUtils.contains(className, " implements ")) {
            className = StringUtils.trim(StringUtils.substringBefore(className, " implements "));
        } else {
            className = StringUtils.trim(className);
        }
    } else if (StringUtils.contains(code, " interface ")) {
        className = StringUtils.substringAfter(className, " interface ");
        if (StringUtils.contains(className, " extends ")) {
            className = StringUtils.substringBefore(className, " extends ").trim();
        } else {
            className = StringUtils.trim(className);
        }
    } else if (StringUtils.contains(code, " enum ")) {
        className = StringUtils.trim(StringUtils.substringAfter(className, " enum "));
    } else {
        return StringUtils.EMPTY;
    }
    return className;
}