public static void main(String[] args) {
    String unixPath = "/test/linux/path";
    String windowsPath = "\\test\\windows\\path";
    System.out.println(FilenameUtils.separatorsToWindows(unixPath));
    System.out.println(FilenameUtils.separatorsToUnix(windowsPath));
    System.out.println(FilenameUtils.separatorsToSystem(windowsPath));
}