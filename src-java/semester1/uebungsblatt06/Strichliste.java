package semester1.uebungsblatt06;

import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Strichliste {

    public static void main(String[] args) throws IOException {

        String filename = "C:\\Users\\Luca\\Lokaler Ordner\\Strichliste.txt";

        Map<String, Integer> occurrences = new HashMap<>();

        FileReader fileReader = new FileReader(filename, StandardCharsets.UTF_8);
        CharBuffer buffer = CharBuffer.allocate(1024);

        String leftover = null;

        while (fileReader.read(buffer) > 0) { // read until there's nothing more to read
            buffer.flip(); // "read mode"

            // leftover of last iteration empty?
            boolean leftoverEmpty = (leftover == null);

            // save the last name as leftover, if it could continue in next iteration
            boolean newLeftover = true;

            String namesString = leftoverEmpty ? buffer.toString() : leftover + buffer;
            String trimmedNamesString = namesString.trim();

            // last name is followed by ',' => name is over for sure and namesString can be trimmed
            if (trimmedNamesString.endsWith(",")) {
                namesString = trimmedNamesString;
                newLeftover = false;
            }

            String[] names = namesString.split(",");

            if (names.length > 0) {

                // behave differently if leftover has to be kept (don't apply same operations to last name)
                int endIndex = newLeftover ? names.length - 1 : names.length;

                for (int i = 0; i < endIndex; i++) {
                    // name found
                    // => can increment occurrences for that name (trim() to get rid of leading and trailing spaces)
                    incrementForKey(names[i].trim(), occurrences);
                }

                if (newLeftover) {
                    leftover = names[names.length - 1]; // save leftover
                } else {
                    leftover = null; // no leftover
                }
            }

            buffer.clear(); // "write mode" for next read() in loop head
        }

        fileReader.close();

        // increment occurrences for last leftover (if there is any)
        if (leftover != null) {
            incrementForKey(leftover.trim(), occurrences);
        }

        // print occurrences
        occurrences.keySet().stream().sorted((k1, k2) -> occurrences.get(k2) - occurrences.get(k1)).forEach(name ->
                System.out.println(name + ": " + occurrences.get(name)));
    }

    private static void incrementForKey(String key, Map<String, Integer> map) {
        if (!(key == null || key.equals(""))) { // key not valid
            Integer valueBefore = map.get(key);
            if (valueBefore == null) valueBefore = 0;
            map.put(key, ++valueBefore); // put incremented valueBefore
        }
    }
}
