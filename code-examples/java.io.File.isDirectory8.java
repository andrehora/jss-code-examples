public static void zip(String targetPath, String destinationFilePath, String password) {
    try {
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

        if (password.length() > 0) {
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
            parameters.setPassword(password);
        }

        ZipFile zipFile = new ZipFile(destinationFilePath);

        File targetFile = new File(targetPath);
        if (targetFile.isFile()) {
            zipFile.addFile(targetFile, parameters);
        } else if (targetFile.isDirectory()) {
            zipFile.addFolder(targetFile, parameters);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}