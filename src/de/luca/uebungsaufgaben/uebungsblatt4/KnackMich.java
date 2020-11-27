package de.luca.uebungsaufgaben.uebungsblatt4;

public class KnackMich {
    private static final String key = generateKey();

    public static void main(String[] args) {

        // Errate hier den Schlüssel.
        for (int i = 0; i < (1 << 9); i++) {
            String guess = Integer.toBinaryString(i);

            int length = guess.length();
            if (length < 9) {
                for (int j = 0; j < 9 - length; j++) {
                    guess = "0" + guess;
                }
            }
            System.out.println(guess);

            if (isCorrect(guess)) {
                System.out.println("Erratener Schlüssel: " + guess);
                System.out.println("Richtiger Schlüssel: " + key);
                break;
            }
        }
    }

    public static boolean isCorrect(String guess) {
        return key.equals(guess);
    }

    public static String generateKey() {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (Math.random() > 0.5) {
                key.append("1");
            } else {
                key.append("0");
            }
        }
        return key.toString();
    }
}
