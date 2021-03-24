public void writingTextFiles() throws IOException {
        
        File outFile = new File("target/writeme.txt");
        Files.write("Nothing to see here. Move along.", outFile, Charsets.UTF_8);
        Files.append("\nNo, really.", outFile, Charsets.UTF_8);
        
}