public static boolean saveData2SDCardPrivateFileDir(byte[] data, String type, String filename, Context context) {
    if (isSDCardMounted()) {
        File path = context.getExternalFilesDir(type);
        if (!path.exists()) {
            path.mkdir();
        }
        String file = path.getAbsolutePath() + File.separator + filename;
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(data);
            os.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return false;
}