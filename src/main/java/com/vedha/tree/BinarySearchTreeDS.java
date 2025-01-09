package com.vedha.tree;


public class BinarySearchTreeDS<T> {

    Node root;

    public BinarySearchTreeDS(T initialData) {

        this.root = new Node(initialData);
    }

    public class Node {

        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   ", left=" + left +
                   ", right=" + right +
                   '}';
        }
    }

    int insertCount;
    int insertMethodCount;

    public void add(T data) {

        insertCount = 0;
        insertMethodCount = 0;
        System.out.println("Inserting: " + data);

        insert(this.root, data);

        System.out.println("insertCount: " + insertCount);
        System.out.println("insertMethodCount: " + insertMethodCount);
    }

    // Time Complexity O(H), H -> Height of the Tree, based on height of the tree.
    // if root:50 > data:40 ? left side : right side
    private Node insert(Node root, T data) {

        insertMethodCount++;
        if (root == null) {

            insertCount++;
            return new Node(data);
        }

        if ((int) root.data > (int) data) {

            root.left = insert(root.left, data);
        } else {

            root.right = insert(root.right, data);
        }

        return root;
    }

    public boolean contains(T data) {

        return search(this.root, data) != null;
    }

    public T search(T data) {

        Node search = search(this.root, data);
        return search == null ? null : search.data;
    }

    // Time Complexity O(H), H -> Height of the Tree, based on height of the tree.
    private Node search(Node root, T data) {

        if (root == null || root.data.equals(data)) {

            return root;
        }

        if ((int) root.data > (int) data) {

            return search(root.left, data);
        } else {

            return search(root.right, data);
        }
    }

    public void displayTree() {

        System.out.println("this.root = " + this.root);
    }

    public void displayTreeInOrder() {

        System.out.print("Data: { ");

        inOrder(this.root);

        System.out.println("}");
    }

    // In BinarySearchTreeDS lowest element will be added in left node,
    // and greatest element will be in right node.
    // Inorder Will walk through left side first so ascending order data will come.
    private void inOrder(Node root) {

        if (root != null) {

            // Inorder -> Left, Root, Right
            inOrder(root.left);
            System.out.print(root.data + ", ");
            inOrder(root.right);
        }
    }

    private boolean isDelete = false;

    public boolean delete(T data) {

        isDelete = false;
        this.root = delete(this.root, data);

        return isDelete;
    }

    private Node delete(Node root, T data) {

        if (root == null) {

            return null;
        }

        if ((int) root.data < (int) data) {

            root.right = delete(root.right, data);
        } else if ((int) root.data > (int) data) {

            root.left = delete(root.left, data);
        } else {

            if (root.left == null) {

                isDelete = true;
                return root.right;
            } else if (root.right == null) {

                isDelete = true;
                return root.left;
            } else {

                root.data = min(root.right);
                root.right = delete(root.right, root.data);
                isDelete = true;
            }
        }

        return root;
    }

    // Left side will be min value.
    private T min(Node root) {

        T minVal = root.data;
        while (root.left != null) {

            minVal = root.data;
            root = root.left;
        }
        return minVal;
    }

    public static void main(String[] args) {

        BinarySearchTreeDS<Integer> integerBinarySearchTreeDS = new BinarySearchTreeDS<>(50);
        integerBinarySearchTreeDS.add(10);
        integerBinarySearchTreeDS.add(30);
        integerBinarySearchTreeDS.add(20);
        integerBinarySearchTreeDS.add(60);
        integerBinarySearchTreeDS.add(40);
        integerBinarySearchTreeDS.add(100);

        integerBinarySearchTreeDS.displayTreeInOrder();

        System.out.println("search = " + integerBinarySearchTreeDS.search(60));
        System.out.println("contains = " + integerBinarySearchTreeDS.contains(100));

        System.out.println("search = " + integerBinarySearchTreeDS.search(150));
        System.out.println("contains = " + integerBinarySearchTreeDS.contains(200));

        System.out.println("delete = " + integerBinarySearchTreeDS.delete(200));
        System.out.println("delete = " + integerBinarySearchTreeDS.delete(50));

        integerBinarySearchTreeDS.displayTreeInOrder();
        integerBinarySearchTreeDS.displayTree();
    }
}
