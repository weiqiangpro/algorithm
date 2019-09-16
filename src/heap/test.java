package heap;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(43);
        list.add(4);
        list.add(532);
        list.add(6);
        list.add(7);
        list.add(12);
        ArryHeap<Integer> heap1 = new ArryHeap<Integer>(list);
        int n = heap1.size();
        for (int i = 0;i < n;i++){
            System.out.println(heap1.removeMax());
        }
//        heap.removeMax();
//        heap.show();
    }
}
