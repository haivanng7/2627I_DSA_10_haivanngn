import java.util.Scanner;

public class Bai4 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Chèn một giá trị vào cây tìm kiếm nhị phân
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

    // Tìm tổ tiên chung thấp nhất của v1 và v2
    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }

        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        Node ancestor = lca(root, v1, v2);
        System.out.println(ancestor.data);

        sc.close();
    }
}