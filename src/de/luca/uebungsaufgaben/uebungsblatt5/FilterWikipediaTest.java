package de.luca.uebungsaufgaben.uebungsblatt5;

import java.io.*;
import java.net.URL;

public class FilterWikipediaTest {

    public static void main(String[] args) throws IOException {
        Reader rd = new FuckFilter(new BufferedReader(new InputStreamReader(
                new URL("https://de.wikipedia.org/wiki/Fuck").openStream())));
        Writer w = new BufferedWriter(new FileWriter("wiki.html"));
        rd.transferTo(w);
        w.flush();
        w.close();
        rd.close();
    }
}
