package de.luca.uebungsaufgaben.uebungsblatt05;

import java.io.IOException;
import java.io.Reader;

public class LineBreakAdder extends Reader {

    private static final int WORDS_IN_A_LINE = 10;

    private final Reader in;
    private int wordLineCounter = 0;

    public LineBreakAdder(Reader in) {
        super();
        this.in = in;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int charsRead = in.read(cbuf, off, len);
        for (int i = off; i < off + len && i < cbuf.length; i++) {
            if (cbuf[i] == ' ') {
                wordLineCounter++;
                if (wordLineCounter == WORDS_IN_A_LINE) {
                    wordLineCounter = 0;
                    cbuf[i] = '\n';
                }
            }
        }
        return charsRead;
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
