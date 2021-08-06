package semester1.uebungsblatt09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Aufgabe9 {

    public static void main(String[] args) {

        List<Integer> zahlen = new LinkedList<>();
        zahlen.add(5);
        zahlen.add(74);
        zahlen.add(58);
        zahlen.add(87);
        zahlen.add(37);
        zahlen.add(4);
        zahlen.add(35);
        zahlen.add(22);

        Iterator<Integer> iterator = zahlen.iterator();

        //noinspection Java8CollectionRemoveIf
        while (iterator.hasNext()) if (iterator.next() % 2 != 0) iterator.remove();
        System.out.println(zahlen);

        zahlen.removeIf(it -> it % 2 == 0);
        System.out.println(zahlen);
    }
}
