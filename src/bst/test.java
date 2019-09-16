package bst;

public class test {
    public static void main(String[] args) {
//        BST2<Integer> bst = new BST2<>();
//        bst.add(5);
//        bst.add(3);
//        bst.add(6);
//        bst.add(4);
//        bst.add(7);
//        bst.add(13);
//        bst.add(31);
//bst.delete(13);
//bst.inshow();
//bst.finmin();
//bst.finmax();
//        bst.removemin();
//        System.out.println(bst.removemin());
//        System.out.println("--------------");
//        System.out.println(bst.removemax());
//        System.out.println("--------------");
//        System.out.println("--------------");
//        System.out.println(bst.getSize());
//        BST<Integer> bst1 = new BST<>();
//        bst1.add(5);
//        bst1.add(3);
//        bst1.add(6);
//        bst1.add(2);
//        bst1.add(7);`
//        bst1.add(13);
//        bst1.add(31);
//        System.out.println(bst1.con(3));
//        Integer a =1;
//        Integer b =1;
//        Integer c =500;
//        Integer d =500;
//        System.out.println(a==b);
//        System.out.println(c==d);
//
//
//        String s = "aaa";
//        String[] ss = s.split(",");
//        System.out.println(s.split(",").length);
//
//        float e = 10.5f;
//        System.out.println(e/0);


        try {
            num(10);
        }catch (Exception ex ){
            System.out.println("main e");
        }
        System.out.println("main f");
    }
    public  static int num(int a){
        try {
            return a/0;

        }catch (Exception e ){
            System.out.println("method e");
        }
        finally {
            System.out.println("method f");
        }
        return 100;
    }
    static {
        System.out.println("111");
    }
}
