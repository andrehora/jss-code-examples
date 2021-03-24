public static void usingFilenameUtils() throws IOException {
      String path = "C:\\dev\\project\\file.txt";
      System.out.println("Full Path: " +FilenameUtils.getFullPath(path));
      System.out.println("Relative Path: " +FilenameUtils.getPath(path));
      System.out.println("Prefix: " +FilenameUtils.getPrefix(path));
      System.out.println("Extension: " + FilenameUtils.getExtension(path));
      System.out.println("Base: " + FilenameUtils.getBaseName(path));
      System.out.println("Name: " + FilenameUtils.getName(path));

      String filename = "C:/commons/io/../lang/project.xml";
      System.out.println("Normalized Path: " + FilenameUtils.normalize(filename));
}