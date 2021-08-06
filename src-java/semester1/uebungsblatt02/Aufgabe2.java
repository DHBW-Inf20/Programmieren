package semester1.uebungsblatt02;

public class Aufgabe2 {

    public static void main(String[] args) {
        int a = 7;
        int b = 2;

        int temp = a;

        a = b;
        b = temp;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
