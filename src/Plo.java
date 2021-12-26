/**
 * Created by qiangzeng on 17/7/13.
 */
public class Plo {
   static  int sum[]=new int[200];
    public static void fill(){
        sum[0]=1;
        int index=1;
        for (int i=2;i<20;i++){
            for (int j=1;j<=i;j++){
                sum[index++]=j;
            }
        }

    }
    public static void iteration(){
        for (int i : sum) {
            System.out.print(i+" ");
        }

    }
    public static  int getIndex(int index){
        return sum[index];
    }
    public static void main(String[] args) {
        fill();
        iteration();
        int value = getIndex(8);
        System.out.println("value:"+value);

    }
}
