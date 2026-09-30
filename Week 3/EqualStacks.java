import java.io.*;
import java.util.*;

public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int x : h1) sum1 += x;
        for (int x : h2) sum2 += x;
        for (int x : h3) sum3 += x;

        int i1 = 0, i2 = 0, i3 = 0;

        while (i1 < h1.size() && i2 < h2.size() && i3 < h3.size()) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1.get(i1++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2.get(i2++);
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= h3.get(i3++);
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());

        List<Integer> h1 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            h1.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> h2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            h2.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> h3 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n3; i++) {
            h3.add(Integer.parseInt(st.nextToken()));
        }
        int result = equalStacks(h1, h2, h3);
        System.out.println(result);
    }
}