public class Bai6 {
    static class Node {
        int val;
        int ht;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.ht = 0; // Nút mới là nút lá
        }
    }

    static int height(Node node) {
        return node == null ? -1 : node.ht;
    }

    static void updateHeight(Node node) {
        node.ht = 1 + Math.max(height(node.left), height(node.right));
    }

    static Node rotateLeft(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        updateHeight(root);
        updateHeight(newRoot);
        return newRoot;
    }

    static Node rotateRight(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        updateHeight(root);
        updateHeight(newRoot);
        return newRoot;
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        updateHeight(root);
        int balance = height(root.left) - height(root.right);

        if (balance > 1) {
            if (val > root.left.val) {
                root.left = rotateLeft(root.left); // Trường hợp trái-phải
            }
            return rotateRight(root);
        }

        if (balance < -1) {
            if (val < root.right.val) {
                root.right = rotateRight(root.right); // Trường hợp phải-trái
            }
            return rotateLeft(root);
        }

        return root;
    }
    public static void main(String[] args) {
        Node root = null;
        int[] values = {3, 2, 4, 5};

        for (int val : values) {
            root = insert(root, val);
        }

        root = insert(root, 6);

        java.util.Queue<Node> queue = new java.util.ArrayDeque<>();
        queue.add(root);

        System.out.println("Cây AVL sau khi chèn 6:");
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.remove();

                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}