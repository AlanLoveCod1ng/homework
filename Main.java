import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        for (int e : list) {
            if (e == 1)
                list.remove(1);
        }
    }
}