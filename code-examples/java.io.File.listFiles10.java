public static long getFolderSize(File dir) {
    if (dir.exists()) {
        long result = 0;
        File[] fileList = dir.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            // Recursive call if it's a directory
            if (fileList[i].isDirectory()) {
                result += getFolderSize(fileList[i]);
            } else {
                // Sum the file size in bytes
                result += fileList[i].length();
            }
        }
        return result; // return the file size
    }
    return 0;
}