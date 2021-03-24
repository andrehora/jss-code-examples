private void downloadFrom(Assignment toDown ) {
    client.sendUTFDataToServer("DOWNLOAD_SUBS");
    client.sendObjectToServer(toDown);
    
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.showOpenDialog(this);
    File downFolder = chooser.getSelectedFile();
    
    
    byte[] data = (byte[]) client.getObjectFromServer();
    try {
        fos = new FileOutputStream(downFolder.getAbsolutePath() + "/" + toDown.getName() + ".zip");
        fos.write(data);
        fos.close();
    } catch (IOException ex) {
        Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
}