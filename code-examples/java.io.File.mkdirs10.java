protected void writeStaticNodesFile(String enodes) {
    try {
        File dir = new File(this.reactContext
                .getFilesDir() + STATIC_NODES_FILES_PATH);
        if (dir.exists() == false) dir.mkdirs();
        File f = new File(dir, STATIC_NODES_FILES_NAME);
        if (f.exists() == false) {
            if (f.createNewFile() == true) {
                WritableArray staticNodes = new WritableNativeArray();
                staticNodes.pushString(enodes);
                Writer output = new BufferedWriter(new FileWriter(f));
                output.write(staticNodes.toString());
                output.close();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}