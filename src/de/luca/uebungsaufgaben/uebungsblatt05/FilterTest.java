package de.luca.uebungsaufgaben.uebungsblatt05;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class FilterTest {

    public static void main(String[] args) throws IOException {
        Reader r = new FuckFilter(new LineBreakAdder(new RandomWordsReader()));


        char[] chars = new char[200];

        // read one char at a time
        for (int i = 0; i < chars.length; i++) {
            //noinspection ResultOfMethodCallIgnored
            r.read(chars, i, 1);
        }
        System.out.println(new String(chars));
        System.out.println(Arrays.toString(chars));


        System.out.println();


        chars = new char[210];

        // read all chars at once
        //noinspection ResultOfMethodCallIgnored
        r.read(chars);
        System.out.println(new String(chars));
        System.out.println(Arrays.toString(chars));


        r.close();
    }
}
