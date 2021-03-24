public Request setDestinationInExternalFilesDir(Context context, String dirType,
        String subPath) {
    final File file = context.getExternalFilesDir(dirType);
    if (file == null) {
        throw new IllegalStateException("Failed to get external storage files directory");
    } else if (file.exists()) {
        if (!file.isDirectory()) {
            throw new IllegalStateException(file.getAbsolutePath() +
                    " already exists and is not a directory");
        }
    } else {
        if (!file.mkdirs()) {
            throw new IllegalStateException("Unable to create directory: "+
                    file.getAbsolutePath());
        }
    }
    setDestinationFromBase(file, subPath);
    return this;
}