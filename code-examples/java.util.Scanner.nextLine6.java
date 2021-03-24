private void userCredentials() {
    AdvancedEncryptionStandard myEncryption = new AdvancedEncryptionStandard();
    Scanner input = new Scanner(System.in, "utf-8");
    Console console = System.console();
    console.printf("Username: ");
    this.username = input.nextLine();

    //Password Field is not prompted
    console.printf("Password: ");
    char[] pass = console.readPassword();
    this.decryptPassword = new String(pass);
    //ecrypts input user password
    this.encryptPassword = myEncryption.encrypt(decryptPassword);
    this.password = encryptPassword;
    System.out.println();
}