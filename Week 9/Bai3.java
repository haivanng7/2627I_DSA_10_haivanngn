class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class Bai3 {
    // Chèn một giá trị vào cây bằng đệ quy
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // In các giá trị theo thứ tự trái, gốc, phải
    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = {4, 2, 7, 1, 3};

        for (int value : values) {
            root = insert(root, value);
        }

        System.out.print("Trước khi chèn: ");
        printInOrder(root);
        System.out.println();

        root = insert(root, 6);

        System.out.print("Sau khi chèn 6: ");
        printInOrder(root);
        System.out.println();
    }
}