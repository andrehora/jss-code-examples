public static void main(String[] args) throws Exception {
    Scanner consoleReader = new Scanner(System.in);

    FileInputStream f = new FileInputStream(consoleReader.nextLine());

    int max = 0;
    if (f.available() > 0)
        max = f.read();
    while (f.available() > 0) {
        int value = f.read();
        if (max < value)
            max = value;
    }
    System.out.println(max);
    f.close();
}