public static void delete(File file) {
    if (file != null && file.exists()) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    delete(child);
                }
            }
            file.delete();
        } else {
            file.delete();
        }
    }
}