package sort.Quick_Sort;

public class Quick_Sort {
    public void quicksort(int[] arr){
        _quicksort(arr,0,arr.length-1);
    }

    private void _quicksort(int[] arr,int l,int r){
    if (l>=r)
        return;
    int p = _partition2(arr,l,r);
    _quicksort(arr,l,p-1);
    _quicksort(arr,p+1,r);
    }

    private int _partition(int[] arr, int l, int r) {
        /**
         * 优化操作  随机取一个数作为中间值
         */
        swap(arr,l, (int) (Math.random()*(r-l)+l));

        int v = arr[l];
        int j = l;
        for (int i = j+1;i <= r ; i++){
            if (arr[i] < v){
                swap(arr,i,j+1);
                j++;
            }
        }
        swap(arr,j,l);
        return  j;
    }

    /**
     * 二路快速排法
     */
    private int _partition2(int[] arr, int l, int r) {
        swap(arr,l, (int) (Math.random()*(r-l)+l));
        int v = arr[l];
        int i = l+1,j=r;
        while (true){
            while (i<=r && arr[i] <= v) i++;
            while (j>=l+1 && arr[j] >= v) j--;
            if (i >= j ){
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
    return j;
    }
    /**
     * 三路快速排
     */
    private int _partition3(int[] arr, int l, int r) {
        swap(arr,l, (int) (Math.random()*(r-l)+l));
        int v = arr[l];
        int lt = l+1,gt = r,i = l+1;
        while (i <= gt){
            if (arr[i] < v)
                swap(arr,lt++,i++);
            else if (arr[i] > v)
                swap(arr,gt--,i);
            else
                i++;
        }
        swap(arr,l,lt-1);
        return lt-1;
    }
    private void swap(int[] arr, int a , int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] =t ;
    }

    public static void main(String[] args) {
    int[] a ={5,2,7,3,9,1,2,90,31,4,23,13};

    new Quick_Sort().quicksort(a);

        for (int i : a) {
            System.out.println(i);
        }
    }
}
