private static void concat_() {
     
        System.out.println("*** Concatenation ***");
     
        // base and added names are paths
        String filename1 = "X:\\JCG\\Examples\\org.apache.commons.io.FilenameUtils";
        String filename2 = "articles\\";
        String concatenatedPath = FilenameUtils.concat(filename1, filename2);
        System.out.println("Filename 1: " + filename1 );
        System.out.println("Filename 2: " + filename2 );
        System.out.println("Concatenated: " + concatenatedPath);
         
        // base is path and added name is file name
        filename1 = "X:\\JCG\\Examples\\org.apache.commons.io.FilenameUtils";
        filename2 = "FilenameUtilsExample.java";
        concatenatedPath = FilenameUtils.concat(filename1, filename2);
        System.out.println("Filename 1: " + filename1 );
        System.out.println("Filename 2: " + filename2 );
        System.out.println("Concatenated: " + concatenatedPath);
         
        // base is reative path and added name is file name
        filename1 = "org.apache.commons.io.FilenameUtils";
        filename2 = "FilenameUtilsExample.java";
        concatenatedPath = FilenameUtils.concat(filename1, filename2);
        System.out.println("Filename 1: " + filename1 );
        System.out.println("Filename 2: " + filename2 );
        System.out.println("Concatenated: " + concatenatedPath);    
}