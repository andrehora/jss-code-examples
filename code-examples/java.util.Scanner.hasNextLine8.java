private static void load(Language language, String string) throws Exception {
  Scanner scanner = new Scanner(string);
  while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if (line.startsWith("#")) continue;
    int index = line.indexOf("=");
    if (index == -1) continue;
    String str = line.substring(0, index).toLowerCase();
    String localization = line.substring(index + 1);
    language.add(str, localization);
  }
  scanner.close();
}