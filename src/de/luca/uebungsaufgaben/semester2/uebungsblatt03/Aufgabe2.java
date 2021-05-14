package de.luca.uebungsaufgaben.semester2.uebungsblatt03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@SuppressWarnings("unused")
public class Aufgabe2 {

    public static void copyFile(String src, String target) throws IOException {
        FileChannel in = new FileInputStream(src).getChannel();
        FileChannel out = new FileOutputStream(target).getChannel();
        in.transferTo(0, in.size(), out);
    }
}
