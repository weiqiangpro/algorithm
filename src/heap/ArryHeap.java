package heap;

import java.util.ArrayList;
import java.util.List;

public class ArryHeap<E extends Comparable<E>> implements Heap<E> {
    List<E> list;

    public ArryHeap() {
        this.list = new ArrayList<>();
    }
    public ArryHeap(List<E> list)  {
        this.list = list;
        int j;

        for (int i = getparent(list.size()-1);i >= 0; i--) {
//        下沉操作
            while (getleft(i) < size()) {
                j = getleft(i);
                if (getright(i) < list.size() && list.get(getright(i)).compareTo(list.get(getleft(i))) > 0) {
                    j++;
                }
                if (list.get(j).compareTo(list.get(i)) < 0)
                    break;
                swap(i, j);
                i = j;
            }
        }
    }


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size()!=0;
    }



    private int getparent(int i) {
        return (i-1)/2;
    }

    private int getleft(int i) {
        return 2*i+1;
    }

    private int getright(int i) {
        return 2*i+2;
    }
    private void swap(int i,int j){
        E a = list.get(i);
        list.set(i,list.get(j));
        list.set(j,a);
    }
    @Override
    public void add(E e){
        list.add(e);
        int i = list.size()-1;
        while (i > 0 && list.get(getparent(i)).compareTo(list.get(i)) < 0){
            swap(i,getparent(i));
            i = getparent(i);
        }
    }

    public E findMax(){
        if (list.size()==0)
            throw  new IllegalArgumentException("该堆为空");
        return list.get(0);
    }

    public E removeMax(){
        E max = findMax();
        list.set(0,list.get(size()-1));
        list.remove(size()-1);
        int i = 0,j;
//        下沉操作
        while (getleft(i) < size()){
            j = getleft(i);
            if (getright(i) < size()&&list.get(getright(i)).compareTo(list.get(getleft(i))) > 0){
                j++;
            }
            if (list.get(j).compareTo(list.get(i)) < 0)
                break;
            swap(i,j);
            i = j;
        }

        return max;
    }

    public void show() {
        for(E e:list){
            System.out.println(e);
        }
    }
}
