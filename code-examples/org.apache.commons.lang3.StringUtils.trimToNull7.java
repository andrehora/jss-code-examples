public static String getFileKey(String name) {
    String prefix = "/upload/" + DateKit.dateFormat(new Date(), "yyyy/MM");
    if (!new File(AttachController.CLASSPATH + prefix).exists()) {
        new File(AttachController.CLASSPATH + prefix).mkdirs();
    }

    name = StringUtils.trimToNull(name);
    if (name == null) {
        return prefix + "/" + UUID.UU32() + "." + null;
    } else {
        name = name.replace('\\', '/');
        name = name.substring(name.lastIndexOf("/") + 1);
        int index = name.lastIndexOf(".");
        String ext = null;
        if (index >= 0) {
            ext = StringUtils.trimToNull(name.substring(index + 1));
        }
        return prefix + "/" + UUID.UU32() + "." + (ext == null ? null : (ext));
    }
}