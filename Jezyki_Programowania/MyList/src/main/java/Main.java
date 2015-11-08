import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQUIER
 * on 2015-11-06.
 */
public class Main {

    public static void main(String[] args) {

        List<String> a = new ArrayList<>();

        MyArrayList<String> b = new MyArrayList<>();

        b.add("Hello");
        b.add("Hello");
        b.add("Hello");
        b.add("Hello");
        b.add("Hello");
        b.add("Hello");
        b.add("Hello");
        b.add("World");

        a.add("this");
        a.add("sucks");

        b.addAll(a);

        for (int i = 0; i < b.size(); i++) {

            System.out.println(b.get(i) + " " + b.size());
        }

        System.out.println(b.contains("Hello"));
        System.out.println(b.contains("HelloW"));
        System.out.println(b.indexOf("this"));
        System.out.println(b.indexOf("HelloW"));
        System.out.println(b.lastIndexOf("Hello"));
    }

}
