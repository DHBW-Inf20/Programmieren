package semester1.uebungsblatt09;

public class Aufgabe5 {

    public static void main(String[] args) {
        System.out.println("-42: " + someMethod(-42));
        System.out.println("0: " + someMethod(0));
        System.out.println("42: " + someMethod(42));
    }

    private static String someMethod(int parameter) {
        try {
            if (parameter < 0) throw new ArithmeticException();
            return "try";
        } catch (ArithmeticException e) {
            return "catch";
        } finally {
            System.out.println("finally");
        }
    }
}
