public static boolean mkdirsWithExistsCheck(File dir) {
  if (dir.mkdir() || dir.exists()) {
    return true;
  }
  File canonDir = null;
  try {
    canonDir = dir.getCanonicalFile();
  } catch (IOException e) {
    return false;
  }
  String parent = canonDir.getParent();
  return (parent != null) && 
         (mkdirsWithExistsCheck(new File(parent)) &&
                                    (canonDir.mkdir() || canonDir.exists()));
}