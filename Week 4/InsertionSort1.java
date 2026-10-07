import java.util.Scanner;

public class InsertionSort1 {

    static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

    static void insertionSort1(int n, int[] arr) {
        int storedVal = arr[n - 1];
        int i = n - 2;

        while (i >= 0 && arr[i] > storedVal) {
            arr[i + 1] = arr[i];
            printArray(arr);
            i--;
        }

        arr[i + 1] = storedVal;
        printArray(arr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }
}