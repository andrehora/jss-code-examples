public static void main(String[] args) {
    // String IDCardNum="210102820826411";
    // String IDCardNum="210102198208264114";
    while (true) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        if (n.equals("N") || n.equals("n")) {
            break;
        }
        String IDCardNum = input.nextLine();

        IDCardUtil cc = new IDCardUtil();
        System.out.println(cc.IDCardValidate(IDCardNum));
    }
    // System.out.println(cc.isDate("1996-02-29"));
}