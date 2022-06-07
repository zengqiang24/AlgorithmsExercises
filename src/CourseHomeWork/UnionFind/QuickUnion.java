package UnionFind;

/**
 * Created by qiangzeng on 16/11/27.
 */
public class QuickUnion extends Quick {
    private int size[];
    private int maxRoots[];
    private int minRoots[];

    public QuickUnion(int N) {
        super(N);
        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
        maxRoots = new int[count];
        for (int i = 0; i < N; i++) {
            maxRoots[i] = i;
        }
        minRoots = new int[count];
        for (int i = 0; i < N; i++) {
            minRoots[i] = i;
        }
    }

    @Override
    void union(int p, int q) {
        int rp = find(p);
        int rq = find(q);
        if (rp == rq) return;
        if (size[rp] > size[rq]) {
            ids[rq] = ids[rp];

            size[rp] += size[rq];
        } else {
            ids[rp] = ids[rq];
            size[rq] += size[rp];
        }

        if (p < q) {
            maxRoots[ids[rq]] = q;
            minRoots[ids[rq]] = p;
        } else {
            maxRoots[ids[rq]] = p;
            minRoots[ids[rq]] = q;
        }
        count--;
    }

    @Override
    boolean connection(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    @Override
    int find(int i) {
        return root(i);
    }

    public int findMax(int i) {
        int root = root(i);
        return maxRoots[root];
    }

    public int findMin(int i) {
        int root = root(i);
        return minRoots[root];
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        if (!quickUnion.connection(1, 4)) {
            quickUnion.union(1, 4);
        }
        if (!quickUnion.connection(5, 1)) {
            quickUnion.union(5, 1);
        }


        System.out.println(quickUnion);
        System.out.println(quickUnion.findMax(4));
        System.out.println(quickUnion.findMin(4));
    }
}
