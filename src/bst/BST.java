package bst;

public class BST<E extends Comparable<E>>   {
    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    private int size;
    private Node root;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public void add(E e) {
        if (this.root == null){
            root = new Node(e);
            this.size++;
        }
       add(root,e);
    }


    public boolean con( E e){
        Node pre = root;
        while (pre!=null) {
            if (e.compareTo(pre.e)==0)
                return true;
            if (e.compareTo(pre.e)<0)
                pre= pre.left;
            if (e.compareTo(pre.e)>0)
                pre=pre.right;
        }
        return false;
    }


    private void add(Node node,E e){
        if (e.equals(node.e))
            return;
        if (e.compareTo(node.e)<0&&node.left==null) {
            node.left = new Node(e);
            this.size++;
        }
        if (e.compareTo(node.e)>0&&node.right==null) {
            node.right = new Node(e);
            this.size++;
        }
        if (e.compareTo(node.e)<0)
            add(node.left,e);
        if (e.compareTo(node.e)>0)
            add(node.right,e);
    }

}
