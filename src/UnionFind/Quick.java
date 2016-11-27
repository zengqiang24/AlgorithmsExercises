package UnionFind;

/**
 * Created by qiangzeng on 16/11/24.
 */
public abstract class Quick {
    protected int[] ids;
    protected int N;
    protected int count;
    public Quick(int N) {
        this.N = N;
        count=N;
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    abstract void union(int p, int q);

    abstract boolean connection(int p, int q);

    abstract int find(int p);

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int id : ids) {
            sb.append(id);
        }
        return sb.toString();
    }
}
