public void read(Integer[][] array) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("signal.CSV"));
    int columns = 0;
    int row = 0;
    scanner.useDelimiter("\\D+");
    while (scanner.hasNext()) {
        array[row][columns] = scanner.nextInt();
        columns += 1;
        if (columns == 4) {
            columns = 0;
            row += 1;
        }
        //System.out.println(array[0][0]);
    }

    scanner.close();
}