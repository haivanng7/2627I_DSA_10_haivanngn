import java.util.*;
public class w4_tailop_25023542 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] c = new Integer[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        Arrays.sort(c, Collections.reverseOrder());
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        System.out.println(h);
    }
}