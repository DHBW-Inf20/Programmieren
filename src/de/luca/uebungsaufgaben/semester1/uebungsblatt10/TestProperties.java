package de.luca.uebungsaufgaben.semester1.uebungsblatt10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) throws IOException {

        Properties testProperties = new Properties();

        testProperties.load(
                new FileReader("src/de/luca/uebungsaufgaben/uebungsblatt10/test-properties.properties")
        );

        String in = testProperties.getProperty("in");
        String out = testProperties.getProperty("out appended", "");
        out += ("-" + in);
        testProperties.setProperty("out appended", out);

        testProperties.store(
                new FileWriter("src/de/luca/uebungsaufgaben/uebungsblatt10/test-properties.properties"),
                "Add your comments here!"
        );
    }
}
