public static String searchDirForPath(File dir, int bucketId) {
    File[] files = dir.listFiles();
    if (files != null) {
        for (File file : files) {
            if (file.isDirectory()) {
                String path = file.getAbsolutePath();
                if (GalleryUtils.getBucketId(path) == bucketId) {
                    return path;
                } else {
                    path = searchDirForPath(file, bucketId);
                    if (path != null) return path;
                }
            }
        }
    }
    return null;
}