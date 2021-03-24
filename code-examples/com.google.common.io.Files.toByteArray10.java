private boolean hasContent(byte[] generatedContent, File file) {
    if (generatedContent.length != file.length()) {
        return false;
    }

    byte[] existingContent;
    try {
        existingContent = Files.toByteArray(this.file);
    } catch (IOException e) {
        // Assume changed if reading old file fails
        return false;
    }

    return Arrays.equals(generatedContent, existingContent);
}