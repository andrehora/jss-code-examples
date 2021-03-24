private static File getOutputFile(String extension) {
    outputFilename = args.HasOption("output-file") ? 
            args.GetOption("output-file") : 
            FilenameUtils.getBaseName(args.GetOption("access-file")) + "." + extension;
    
    File outFile = new File(FilenameUtils.concat(FilenameUtils.getFullPath(args.GetOption("access-file")), outputFilename));
    if(outFile.exists()) {
        try {
            outFile.delete();
        } catch(SecurityException e) {
            Error(String.format("Could not delete existing output file '%s'", outputFilename));
            return null;
        }
    }
    
    return outFile;
}