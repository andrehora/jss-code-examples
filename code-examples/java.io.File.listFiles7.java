public static long getFolderSize(File file) throws Exception {
  long size = 0;
  try {
    File[] fileList = file.listFiles();
    for (int i = 0; i < fileList.length; i++) {
      if (fileList[i].isDirectory()) {
        size = size + getFolderSize(fileList[i]);
      } else {
        size = size + fileList[i].length();
      }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
  return size;
}