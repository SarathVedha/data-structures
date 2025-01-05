package com.vedha.tree;

public class BinaryTreeDS<T> {

    /*
    Max node in full tree level of h: 2⁰+2¹+...+2^h, S= 2^h+1 -1.
    Min nodes in full tree of h: h+1

    Max height of btree with n nodes: n-1.
    Min height of btree with n nodes: log2(n+1)-1 . Take ciel value.
    */

    Node root;

    public BinaryTreeDS(T initialData) {

        this.root = new Node(initialData);
    }

    public class Node {

        final T data;
        Node left, right;

        Node(T data) {

            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insertLeft(Node node, T data) {

        node.left = new Node(data);
    }

    public void insertRight(Node node, T data) {

        node.right = new Node(data);
    }

    /*
    * Three Types Tree Traversals or Walk
    * 1. PreOrder -> Root, Left, Right
    * 2. Inorder -> Left, Root, Right
    * 3. PostOrder -> Left, Right, Root
    * By Using Recursion Calls.
    * */
    int preOrder;
    int preOrderMethodCall;
    public void preOrder(Node root) {

        preOrderMethodCall++;
        if (root != null) {

            // PreOrder -> Root, Left, Right
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
            preOrder++;
        }
    }

    int inOrder;
    int inOrderMethodCall;
    public void inOrder(Node root) {

        inOrderMethodCall++;
        if (root != null) {

            // Inorder -> Left, Root, Right
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
            inOrder++;
        }
    }

    int postOrder;
    int postOrderMethodCall;
    public void postOrder(Node root) {

        postOrderMethodCall++;
        if (root != null) {

            // PostOrder -> Left, Right, Root
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
            postOrder++;
        }
    }

    public static void main(String[] args) {

        BinaryTreeDS<Integer> integerBinaryTreeDS = new BinaryTreeDS<>(10);

        integerBinaryTreeDS.insertLeft(integerBinaryTreeDS.root, 20);
        integerBinaryTreeDS.insertRight(integerBinaryTreeDS.root, 30);

        integerBinaryTreeDS.insertLeft(integerBinaryTreeDS.root.left, 40);
        integerBinaryTreeDS.insertRight(integerBinaryTreeDS.root.left, 50);

        integerBinaryTreeDS.insertLeft(integerBinaryTreeDS.root.right, 60);
        integerBinaryTreeDS.insertRight(integerBinaryTreeDS.root.right, 70);

        integerBinaryTreeDS.preOrder(integerBinaryTreeDS.root);
        System.out.print(",preOrder count: " + integerBinaryTreeDS.preOrder);
        System.out.println(",preOrderMethodCall count: " + integerBinaryTreeDS.preOrderMethodCall);

        integerBinaryTreeDS.preOrder = 0;
        integerBinaryTreeDS.preOrderMethodCall = 0;
        integerBinaryTreeDS.preOrder(integerBinaryTreeDS.root);
        System.out.print(",preOrder count: " + integerBinaryTreeDS.preOrder);
        System.out.println(",preOrderMethodCall count: " + integerBinaryTreeDS.preOrderMethodCall);
    }
}
