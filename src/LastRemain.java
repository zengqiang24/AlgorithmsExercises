import java.util.ArrayList;
import java.util.List;
//看不懂
public class LastRemain {
    public static void main(String[] args) {
        System.out.print(lastRemaining(10, 17));

    }

    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int lastIndex = 0;
        while (n > 1) {
            int index = (lastIndex + m - 1) % n;
            lastIndex = index;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
