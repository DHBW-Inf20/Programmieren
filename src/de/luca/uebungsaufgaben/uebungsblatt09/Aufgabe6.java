package de.luca.uebungsaufgaben.uebungsblatt09;

public class Aufgabe6 {

    public static void main(String[] args) {

        // no compile error
        throwsUncheckedException();

        // compile error
        // throwsNoExceptionButDeclaresThrow();
    }

    // no compile error
    private static void throwsUncheckedException() {
        throw new RuntimeException();
    }

    @SuppressWarnings({"RedundantThrows", "unused"})
    private static void throwsNoExceptionButDeclaresThrow() throws Exception {
        // do nothing
    }
}
