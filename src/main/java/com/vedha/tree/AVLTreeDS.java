package com.vedha.tree;


public class AVLTreeDS<T> {

    Node root;

    public AVLTreeDS(T initialData) {

        this.root = new Node(initialData);
    }

    public class Node {

        T data;
        Node left, right;
        int height;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 0;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    ", height=" + height +
                    '}';
        }
    }

    int insertCount;
    int insertMethodCount;

    public void add(T data) {

        insertCount = 0;
        insertMethodCount = 0;
        System.out.println("Inserting: " + data);

        this.root = insert(this.root, data);

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
        } else if ((int) root.data < (int) data) {

            root.right = insert(root.right, data);
        } else {

            return root;
        }

        root.height = max(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;

        // Get the balance factor of this ancestor node to check whether this node became unbalanced or not
        // If this node becomes unbalanced, then there are 4 cases, Left-Left Case, Left-Right Case, Right-Right Case, Right-Left Case
        int balanceFactor = getBalanceFactor(root);
        // Left-Left Case
        if (balanceFactor > 1 && (int) root.left.data > (int) data) {

            return rightRotate(root);
        }

        // Left-Right Case
        if (balanceFactor > 1 && (int) root.left.data < (int) data) {

            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right-Right Case
        if (balanceFactor < -1 && (int) root.right.data < (int) data) {

            return leftRotate(root);
        }

        // Right-Left Case
        if (balanceFactor < -1 && (int) root.right.data > (int) data) {

            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node leftRotate(Node node) {

        Node left = node.left;
        Node right = node.right;

        right.left = node;
        node.right = left;

        node.height = max(getNodeHeight(node.left), getNodeHeight(node.right)) + 1;
        right.height = max(getNodeHeight(right.left), getNodeHeight(right.right)) + 1;

        return right;
    }

    private Node rightRotate(Node node) {

        Node left = node.left;
        Node right = node.right;

        left.right = node;
        node.left = right;

        node.height = max(getNodeHeight(node.left), getNodeHeight(node.right)) + 1;
        left.height = max(getNodeHeight(left.left), getNodeHeight(left.right)) + 1;

        return left;
    }

    // Formula: Balance Factor = Height of Left Subtree - Height of Right Subtree (BF = HL - HR) return -1, 0, 1 based on the balance factor.
    // If the balance factor is greater than 1 or less than -1, then the tree is unbalanced and we need to perform rotations to balance the tree.
    private int getBalanceFactor(Node node) {

        if (node == null) {

            return 0;
        }
        return getNodeHeight(node.left) - getNodeHeight(node.right);
    }

    private int max(int nodeLeft, int nodeRight) {

        return Math.max(nodeLeft, nodeRight);
    }

    private int getNodeHeight(Node node) {

        return node == null ? -1 : node.height;
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

    // In BinarySearchTreeDS lowest element will be added in the left node,
    // and the greatest element will be in the right node.
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

    // The Left side will be min value.
    private T min(Node root) {

        T minVal = root.data;
        while (root.left != null) {

            minVal = root.data;
            root = root.left;
        }
        return minVal;
    }

    public static void main(String[] args) {

        AVLTreeDS<Integer> avlTreeDS = new AVLTreeDS<>(50);
        avlTreeDS.add(20);
        avlTreeDS.add(60);
        avlTreeDS.add(10);
        avlTreeDS.add(30);
        avlTreeDS.add(40);

        avlTreeDS.displayTreeInOrder();
        avlTreeDS.displayTree();

        System.out.println("search = " + avlTreeDS.search(60));
        System.out.println("contains = " + avlTreeDS.contains(100));

        System.out.println("search = " + avlTreeDS.search(150));
        System.out.println("contains = " + avlTreeDS.contains(200));

        System.out.println("delete = " + avlTreeDS.delete(200));
        System.out.println("delete = " + avlTreeDS.delete(50));

        avlTreeDS.displayTreeInOrder();
        avlTreeDS.displayTree();
    }
}
