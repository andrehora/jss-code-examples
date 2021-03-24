public static void main(String [] args)
            throws IOException {
             
        System.out.println("*** File extension and wildcard matching ***");
     
        String [] extensions = {"java", "class"};
        String wildcardMatcher = "*Example?.txt";
     
        Path dirPath = Paths.get("X:\\testdir\\");
        System.out.println("Directory being searched: " + dirPath.toString());
        DirectoryStream dirStream = Files.newDirectoryStream(dirPath);
         
        for (Path filePath : dirStream) {
 
            String filename = filePath.getFileName().toString();
            System.out.println(filename);
             
            // file extension matching
             
            boolean fileFound = FilenameUtils.isExtension(filename, extensions);
             
            if (fileFound) {
             
                System.out.println("    file with java or class extension");
            }
             
           // wild card matching
 
           fileFound = FilenameUtils.wildcardMatch(filename, wildcardMatcher);
 
           if (fileFound) {
             
               System.out.println("    file with *Example?.txt wild card match");
           }
 
        } // end for loop
         
        dirStream.close();
}