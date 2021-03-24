private static void normalize_() {
     
        System.out.println("*** Normalization ***");
 
        String filename = "X:\\JCG\\.\\org.apache.commons.io.FilenameUtils Example\\notes.txt";
        System.out.println("Before: " + filename);
        String normalized = FilenameUtils.normalize(filename);
        System.out.println("After single dot normalization: " + normalized);
         
        filename = "X:\\JCG\\articles\\..\\notes.txt";
        System.out.println("Before: " + filename);
        normalized = FilenameUtils.normalize(filename);
        System.out.println("After double dot normalization: " + normalized);    
}