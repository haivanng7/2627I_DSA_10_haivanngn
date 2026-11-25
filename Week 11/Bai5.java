import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class Bai5 {
    public static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> frequencyDifference = new HashMap<>();

        for (int value : brr) {
            frequencyDifference.merge(value, 1, Integer::sum);
        }
        for (int value : arr) {
            frequencyDifference.merge(value, -1, Integer::sum);
        }

        // Hiệu dương nghĩa là số này xuất hiện ít hơn trong arr.
        return frequencyDifference.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .mapToInt(Map.Entry::getKey)
                .sorted()
                .toArray();
    }

    private static int[] readArray(Scanner scanner) {
        int[] values = new int[scanner.nextInt()];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] arr = readArray(scanner);
            int[] brr = readArray(scanner);

            StringJoiner output = new StringJoiner(" ");
            for (int value : missingNumbers(arr, brr)) {
                output.add(Integer.toString(value));
            }
            System.out.println(output);
        }
    }
}
