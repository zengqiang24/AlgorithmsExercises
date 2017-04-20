import edu.princeton.cs.algs4.StdIn;

/**
 * Created by qiangzeng on 16/12/24.
 */
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        String s1 = StdIn.readString();
        randomizedQueue.enqueue(s1);
        String s2 = StdIn.readString();
        randomizedQueue.enqueue(s2);
        String s3 = StdIn.readString();
        randomizedQueue.enqueue(s3);
        String s4 = StdIn.readString();
        randomizedQueue.enqueue(s4);
        int k;
        k = StdIn.readInt();
        for (int i = 0; i < k; i++) {
            System.out.println(randomizedQueue.sample());
        }
    }
}
