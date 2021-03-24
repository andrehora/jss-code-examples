private static void filenameComponents_() {
     
        String filename = "X:\\JCG\\articles\\org.apache.commons.io.FilenameUtils Example\\notes.txt";
     
        System.out.println("*** File name components ***");
        System.out.println("File name: " + filename);
     
        String prefix = FilenameUtils.getPrefix(filename);
        System.out.println("Prefix: " + prefix);
         
        String path = FilenameUtils.getPath(filename);
        System.out.println("Path: " + path);
         
        String fullPath = FilenameUtils.getFullPath(filename);
        System.out.println("Full path: " + fullPath);
         
        String name = FilenameUtils.getName(filename);
        System.out.println("Name: " + name);
         
        String baseName = FilenameUtils.getBaseName(filename);
        System.out.println("Base name: " + baseName);
         
        String extension = FilenameUtils.getExtension(filename);
        System.out.println("Extension: " + extension);
}