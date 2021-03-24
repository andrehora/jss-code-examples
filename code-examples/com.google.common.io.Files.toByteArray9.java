private static Set<String> getComponentTypes(List<String> files, File assetsDir)
    throws IOException, JSONException {
  Map<String, String> nameTypeMap = createNameTypeMap(assetsDir);

  Set<String> componentTypes = Sets.newHashSet();
  for (String f : files) {
    if (f.endsWith(".scm")) {
      File scmFile = new File(f);
      String scmContent = new String(Files.toByteArray(scmFile),
          PathUtil.DEFAULT_CHARSET);
      for (String compName : getTypesFromScm(scmContent)) {
        componentTypes.add(nameTypeMap.get(compName));
      }
    }
  }
  return componentTypes;
}