public class ScannerUncommonUses {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
 
        // Parsing primitive numbers
        boolean bl = new Scanner("false").nextBoolean();
        byte b = new Scanner("16").nextByte();
        int n = new Scanner("42").nextInt();
        long l = new Scanner("99999999999").nextLong();
        float f = new Scanner("4.2").nextFloat();
        double d = new Scanner("99.99999999").nextDouble();
 
        System.out.printf("/***** Parsing primitive numbers *****/\n\n");
        System.out.printf("boolean: %b\n", bl);
        System.out.printf("byte: %d\n", b);
        System.out.printf("int: %d\n", n);
        System.out.printf("long: %d\n", l);
        System.out.printf("float: %f\n", f);
        System.out.printf("double: %f\n\n", d);
 
        // Using Locale to parse numbers in specific languages
        try {
            double doubleLocale = new Scanner("1.234,56").useLocale(
                    Locale.ITALIAN).nextDouble();
 
            System.out.printf("/***** Using Locales to parse numbers in specific languages *****/\n\n");
            System.out.printf("double (Locale = Italy): %f", doubleLocale);
        } catch (InputMismatchException ime) {
            ime.printStackTrace(System.err);
        }
    }
}