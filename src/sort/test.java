package sort;

import sort.Merge_Sort.Merge_Sort;
import sort.Quick_Sort.Quick_Sort;

import java.util.Arrays;

public class test {
    final static int n = 100000;

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int t;
        for (int i = 0; i < n; i++) {
            t = (int) (Math.random() * n);
            arr1[i] = i;
            arr2[i] = t;
            arr3[i] = i;
        }

        long n1, n2;
        float seconds;

        n1 = System.nanoTime();
        new Quick_Sort().quicksort(arr1);
        n2 = System.nanoTime();
        seconds = (n2 - n1) / 1000000000F;
        System.out.println("快速排序时间为" + seconds + "秒");

        System.out.println(Arrays.equals(arr3, arr1));
        n1 = System.nanoTime();
        new Merge_Sort().mergesort(arr2);
        n2 = System.nanoTime();
        seconds = (n2 - n1) / 1000000000F;
        System.out.println("归并排序时间为" + seconds + "秒");

        n1 = System.nanoTime();
        Arrays.sort(arr3);
        n2 = System.nanoTime();
        seconds = (n2 - n1) / 1000000000F;
        System.out.println("系统排序时间为" + seconds + "秒");
    }

}
