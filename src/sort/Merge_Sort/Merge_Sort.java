package sort.Merge_Sort;

public class Merge_Sort {
    public void mergesort(int[] arr) {
        _mergesort(arr, 0, arr.length - 1);
    }

    private void _mergesort(int[] arr, int l, int r) {
        /**
         * 当数据近乎按顺序的时候， 插入排序的效率会优于归并排序
         * 当大量的数据进行归并排序的时候，当数据量递归的比较小的值的时候，这种情况就会大大增加
         * 此优化适用于大多排序算法
         * if( (r - l) <= 15)
         * 插入排序
         */
        if (l >= r)
            return;

        int mid = (l + r) / 2;
        _mergesort(arr, l, mid);
        _mergesort(arr, mid + 1, r);

        /**
         * 优化操作   如果在前方的最后一个已经小于后面的第一个   就不需要在进行排序
         * 不过 if 操作也会消耗一定的时间
         */
//        if (arr[mid] > arr[mid + 1])
        _merge(arr, l, mid, r);

    }

    private void _merge(int[] arr, int l, int mid, int r) {
        int i = l, j = mid + 1;
        int[] t = new int[r - l + 1];
        for (int m = l; m <= r; m++)
            t[m - l] = arr[m];
        for (int k = l; k <= r; k++) {
            if (i > mid)
                arr[k] = t[(j++) - l];
            else if (j > r)
                arr[k] = t[(i++) - l];
            else if (t[i - l] > t[j - l])
                arr[k] = t[(j++) - l];
            else
                arr[k] = t[(i++) - l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 12, 53, 1, 43, 12, 76, 4, 9, 6, 10, 34};
        new Merge_Sort().mergesort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
