import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Tên lớp riêng để VS Code không chạy nhầm Bai4 của Week 9.
class Bai4Week11 {
    public static int pairs(int k, int[] arr) {
        if (k <= 0) {
            return 0;
        }

        Set<Integer> values = new HashSet<>();
        for (int value : arr) {
            values.add(value);
        }

        int count = 0;
        for (int value : arr) {
            // Chỉ xét từ số nhỏ hơn để mỗi cặp được đếm một lần.
            long partner = (long) value + k;
            if (partner <= Integer.MAX_VALUE && values.contains((int) partner)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(pairs(k, arr));
        }
    }
}
