package UnionFind;

/**
 * Created by qiangzeng on 16/11/24.
 */
public class QuickFind extends Quick {
    public QuickFind(int N) {
        super(N);
    }

    @Override
    void union(int p, int q) {
        int mp = find(p);
        int mq = find(q);
        if (mp != mq) {
            for (int i = 0; i < N; i++) {
                if (ids[i] == mq) ids[i] = mp;
            }
            System.out.println(p + " " + q);
            count--;
        }
    }

    @Override
    boolean connection(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    int find(int p) {
        return ids[p];
    }

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        if (!quickFind.connection(3, 6)) {
            quickFind.union(3, 6);

        }
        if (!quickFind.connection(3, 6)) {
            quickFind.union(3, 6);

        }
        if (!quickFind.connection(6, 9)) {
            quickFind.union(6, 9);

        }
        System.out.println(quickFind);
        System.out.println(quickFind.getCount());

    }


}
