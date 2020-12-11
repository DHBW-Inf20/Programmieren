package de.luca.uebungsaufgaben.uebungsblatt5;

import java.io.Reader;

public class RandomWordsReader extends Reader {

    private static final String[] WORDS = {"fuck", "hello", "bye", "green", "foo", "bar"};

    private String rest = "";

    @Override
    public int read(char[] cbuf, int off, int len) {
        if (off < 0) throw new IndexOutOfBoundsException("off can't be negative");
        if (len < 0) throw new IndexOutOfBoundsException("len can't be negative");
        if (len > cbuf.length - off) throw new IndexOutOfBoundsException("len + off can't be bigger than cbuf.length");

        String output = rest;

        for (int i = 0; i < len; i = output.length()) {
            int result = (int) (Math.random() * 10) % 6;
            output = output + WORDS[result] + " ";
        }

        String result = output.substring(0, len);
        for (int i = off, j = 0; i < off + len; i++, j++) {
            cbuf[i] = result.charAt(j);
        }

        if (output.length() > len) {
            rest = output.substring(len);
        } else {
            rest = "";
        }

        return len;
    }

    @Override
    public void close() {
        rest = "";
    }
}