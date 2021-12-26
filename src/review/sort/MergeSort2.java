package review.sort;

import java.util.Arrays;

/**
 * 合并排序 是采用合并的思想来实现的排序算法， 该算法采用经典的分治策略，分治法将问题分成一些小问题，然后递归求解，而治的阶段则是将分的阶段得到的各答案修补在一起，即分而治之。
 */
public class MergeSort2 {
    static int[] array = {4, 1, 3, 2, 8, 5};

    public static void sort(int[] array, int[] aux, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(array, aux, l, mid);//左边合并排序，使得左子序列有序
        sort(array, aux, mid + 1, r);//右边合并排序，使得右子序列有序
        merge(array, aux, l, r);//将两个有序子数组合并操作
    }

    public static void merge(int[] array, int[] aux, int l, int r) {
        int i = l;// 左子序列指针
        int mid = l + (r - l) / 2;
        int j = mid + 1;// 右子序列指针
        for (int k = l; k <= r; k++) {
            aux[k] = array[k];
        }
        int k = l;
        while (k <= r) {
            if (i > mid) { //如果左子序列指针大于左边界值，
                array[k] = aux[j++];//直接把剩下的右子序列合并过来
            } else if (j > r) {//如果右子序列指针大于右边界
                array[k] = aux[i++]; //把左子序列合并过来。
            } else if (array[i] < array[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
            k++;
        }
    }

    public static void main(String[] args) {
        int[] aux = new int[array.length]; //排序前，创建一个辅助数组，后面合并会用到。
        MergeSort2.sort(array, aux, 0, array.length - 1);
        System.out.print(Arrays.toString(array));
    }
}
