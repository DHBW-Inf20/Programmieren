package semester1.uebungsblatt09;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Aufgabe2 {

    public static void main(String[] args) {

        NavigableSet<String> s = new TreeSet<>();

        s.add("b");
        s.add("a");
        s.add("d");
        s.add("c");

        Iterator<String> it = s.iterator();

        while (it.hasNext()) {
            System.out.println("Value " + it.next());
        }

        it = s.descendingIterator();

        while (it.hasNext()) {
            System.out.println("Value descending: " + it.next());
        }
    }
}
