private File createFile() {
    String dir = Environment.getExternalStorageDirectory() + "/winter/monitor";
    File dirFile = new File(dir);
    if (!dirFile.exists()) {
        dirFile.mkdirs();
    }
    SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINESE);
    String a1 = dateformat1.format(new Date());
    File file = new File(dir + "/" + a1 + ".log");
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return file;
}