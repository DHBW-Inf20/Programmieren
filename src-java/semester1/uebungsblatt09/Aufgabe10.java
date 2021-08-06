package semester1.uebungsblatt09;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Aufgabe10 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Franz");
        list.add("Hans");

        ListIterator<String> listIterator = list.listIterator();
        System.out.println(list);

        while (listIterator.hasNext()) {
            String listElem = listIterator.next();
            if (listElem.equals("Hans")) {
                listIterator.remove();

                // it is not allowed to modify during iteration (at least in this case)
                // list.add("gelöscht");

                // fix for this problem (using ListIterator instead of Iterator)
                listIterator.add("gelöscht");
            }
        }
        System.out.println(list);
    }
}
