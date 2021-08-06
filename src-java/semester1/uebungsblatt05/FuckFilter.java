package semester1.uebungsblatt05;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class FuckFilter extends Reader {

    private final Reader in;
    private char[] buffer;
    private boolean[] alreadyFilteredOnce;

    public FuckFilter(Reader in) {
        super();
        this.in = in;
    }

    // if cbuf changes or results of read in cbuf are used before calling read again, "fuck" between multiple read calls
    // won't be replaced by "****"
    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {

        int charsRead = in.read(cbuf, off, len);

        // same Array instance?
        // noinspection ArrayEquals (suppresses warning, wanted behavior: explicitly test for same referenced array)
        if (!cbuf.equals(buffer)) {
            buffer = cbuf;
            alreadyFilteredOnce = new boolean[buffer.length];
        }
        Arrays.fill(alreadyFilteredOnce, off, off + len, true);

        int startIndexOfContinuouslyFilteredPart = 0;
        int endIndexOfContinuouslyFilteredPart = 0;

        for (int i = 0; i < alreadyFilteredOnce.length; i++) {
            if (!alreadyFilteredOnce[i]) {
                removeFuck(buffer, startIndexOfContinuouslyFilteredPart, endIndexOfContinuouslyFilteredPart);
                startIndexOfContinuouslyFilteredPart = i + 1;
                endIndexOfContinuouslyFilteredPart = 0;
            } else {
                endIndexOfContinuouslyFilteredPart = i + 1;
            }
        }
        removeFuck(buffer, startIndexOfContinuouslyFilteredPart, endIndexOfContinuouslyFilteredPart);

        return charsRead;
    }

    private static void removeFuck(char[] removeFrom, int fromIndex, int toIndex) {
        for (int i = fromIndex; i <= toIndex - 4; i++) {
            if (new String(Arrays.copyOfRange(removeFrom, i, i + 4)).equalsIgnoreCase("fuck")) {
                for (int j = 0; j < 4; j++) {
                    removeFrom[i + j] = '*';
                }
            }
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
