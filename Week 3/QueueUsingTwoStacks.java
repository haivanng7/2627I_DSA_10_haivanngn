import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {
    static Deque<Integer> inbox = new ArrayDeque<>();
    static Deque<Integer> outbox = new ArrayDeque<>();

    static void shift() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) outbox.push(inbox.pop());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                inbox.push(Integer.parseInt(st.nextToken()));
            } else if (type == 2) {
                shift();
                outbox.pop();
            } else {
                shift();
                sb.append(outbox.peek()).append('\n');
            }
        }
        System.out.print(sb);
    }
}