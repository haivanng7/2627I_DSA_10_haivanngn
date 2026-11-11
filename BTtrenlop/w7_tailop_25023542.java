import java.util.*;

public class w7_tailop_25023542 {
    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();
        List<Double> res = new ArrayList<>();

        for (int x : a) {
            if (low.isEmpty() || x <= low.peek()) low.add(x);
            else high.add(x);

            if (low.size() > high.size() + 1) high.add(low.poll());
            else if (high.size() > low.size()) low.add(high.poll());

            if (low.size() > high.size()) res.add((double) low.peek());
            else res.add((low.peek() + (double) high.peek()) / 2.0);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) a.add(sc.nextInt());

        for (double m : runningMedian(a)) {
            System.out.printf("%.1f%n", m);
        }
    }
}