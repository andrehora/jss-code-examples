public static void main(String[] args) {
        File file = new File("f:a/b/c/d.txt");
                 // return file suffix name
        System.out.println(FilenameUtils.getExtension(file.toString()));
                 // return the file name without the suffix name
        System.out.println(FilenameUtils.getBaseName(file.toString()));
                 // return the file name, including the suffix name
        System.out.println(FilenameUtils.getName(file.toString()));
                 / / Get the path to the file (without the file name)
        System.out.println(FilenameUtils.getFullPath(file.toString()));
                 // The path separator is changed to the unix system format, ie /
        System.out.println(FilenameUtils.separatorsToUnix(file.toString()));
                 // Check if the file suffix name is one of the passed parameters (List<String>)
        System.out.println(FilenameUtils.isExtension("txt", new ArrayList<>()));
}