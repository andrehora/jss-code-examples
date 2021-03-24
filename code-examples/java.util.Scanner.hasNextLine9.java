public Map processFile() throws FileNotFoundException {
    //FileReader is used, not File, since File is not Closeable
    scanner = new Scanner(new FileReader(file));
    try {
        //Scanner to get each line
        while (scanner.hasNextLine()) {
            processLine(scanner.nextLine());
        }
    } finally {
        //Close the underlying stream
        scanner.close();
    }
    return map;
}