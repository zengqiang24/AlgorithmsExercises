package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiangzeng on 16/11/30.
 */
public class AutoBoxing {

    public static void cmp(Integer first, Integer second) {
        if (first < second)
            System.out.printf("%d < %d\n", first, second);
        else if (first == second)
            System.out.printf("%d == %d\n", first, second);
        else if (first > second)
            System.out.printf("%d > %d\n", first, second);
        else
            System.out.printf("%d and %d are incomparable\n", first, second);
    }

    public static void main(String[] args) {
        cmp(new Integer(42), 43);
        cmp(new Integer(42), new Integer(42));
        cmp(43, 43);
        cmp(142, 142);

        double x1 = 0.0, y1 = -0.0;
        Double a1 = x1, b1 = y1;
        System.out.println(x1 == y1);
        System.out.println(a1.equals(b1));

        double x2 = 0.0/0.0, y2 = 0.0/0.0;
        Double a2 = x2, b2 = y2;
        System.out.println(x2 != y2);
        System.out.println(!a2.equals(b2));

    }
}
