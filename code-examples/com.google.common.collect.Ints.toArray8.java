private int[] getZoomLevels() {
  final List<Integer> zoomLevels = new ArrayList<>();
  final File[] files = directory.listFiles();

  if (files == null) {
    return new int[]{};
  }

  final Pattern pattern = Pattern.compile("^([0-9]|1[0-9]|2[0-2])$");
  for (final File file : files) {
    final String fileName = file.getName();
    final Matcher matcher = pattern.matcher(fileName);
    if (matcher.matches()) {
      final int value = Integer.parseInt(matcher.group());
      zoomLevels.add(value);
    }
  }
  final int[] result = Ints.toArray(zoomLevels);
  Arrays.sort(result);
  return result;
}