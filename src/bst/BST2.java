package bst;


import java.util.LinkedList;
import java.util.Queue;

public class BST2<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left;
        private Node right;

        private Node(E e) {
            this.e = e;
        }
    }

    private int size;
    private Node root;

    public int getSize() {
        return size;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            this.size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }


    public boolean con(E e) {
        return con(root, e);
    }

    private boolean con(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        if (e.compareTo(node.e) < 0)
            return con(node.left, e);
        else return con(node.right, e);
    }


    public void preshow() {
        preshow(root);
    }

    private void preshow(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preshow(node.left);
        preshow(node.right);
    }

    public void inshow() {
        inshow(root);
    }

    private void inshow(Node node) {
        if (node == null)
            return;
        inshow(node.left);
        System.out.println(node.e);
        inshow(node.right);
    }


    public void show() {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);
            System.out.println(node.e);
        }
    }

    public Node finmin() {
        Node pre = root;
        while (pre != null) {
            if (pre.left == null) {
                System.out.println(pre.e + "-----");
                return pre;
            }
            pre = pre.left;
        }

        return root;
    }

    public Node finmax() {
        Node pre = root;
        while (pre != null) {
            if (pre.right == null) {
                System.out.println(pre.e);
                return pre;
            }
            pre = pre.right;
        }

        return root;
    }

    public E removemin() {
        E e = finmin().e;
        removemin(root);
        return e;
    }

    private Node removemin(Node node) {
        if (node.left == null) {
            size--;
            return node.right;
        }
        node.left = removemin(node.left);
        return node;
    }

    public E removemax() {
        E e = finmax().e;
        removemax(root);
        return e;
    }

    private Node removemax(Node node) {
        if (node.right == null) {
            size--;
            return node.left;
        }
        node.right = removemax(node.right);
        return node;
    }

    public boolean delete(E e) {
        Node node = find(root, e);
        if (node == null)
            return false;
        root = node;
        return true;

    }

    private Node find(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) == 0) {

            if (node.right == null) {
                Node newnode = node.left;
                node.left = null;
                size--;
                return newnode;
            }
            if (node.left == null) {
                Node newnode = node.right;
                node.right = null;
                size--;
                return newnode;
            }
            node.e = removemin(node.right).e;
            return node;
        } else if (e.compareTo(node.e) < 0)
            node.left = find(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = find(node.right, e);
        return node;
    }
}
