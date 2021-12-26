package Sort;

/**
 * Created by qiangzeng on 17/4/20.
 */
public class ShellSort extends ISort {
    @Override
    void sort(Comparable[] a) {
        int N=a.length;
        int h=1;
        while (h<N/3)h=3*h+1;
        while(h>=1){
          for (int i=h;i<N;i++){
                for (int j=i;j>=h&&less(a[j],a[j-h]);j-=h) {
                    exch(a,j,j-h);
                }
            }
            h=h/3;
        }


    }
    public static void main(String[] args) {
        String[] a = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
        ShellSort mShellSort = new ShellSort();
        mShellSort.sort(a);
        mShellSort.show(a);

    }
}
