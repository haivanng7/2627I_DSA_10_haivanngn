import java.io.*;
import java.util.*;

public class SimpleTextEditors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());
        StringBuilder s = new StringBuilder();
        Deque<Object[]> stack = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                String w = st.nextToken();
                s.append(w);
                stack.push(new Object[]{1, w.length()});
            } else if (t == 2) {
                int k = Integer.parseInt(st.nextToken());
                String removed = s.substring(s.length() - k);
                s.setLength(s.length() - k);
                stack.push(new Object[]{2, removed});
            } else if (t == 3) {
                int k = Integer.parseInt(st.nextToken());
                out.append(s.charAt(k - 1)).append('\n');
            } else {
                Object[] op = stack.pop();
                if ((int) op[0] == 1) {
                    s.setLength(s.length() - (int) op[1]);
                } else {
                    s.append((String) op[1]);
                }
            }
        }
        System.out.print(out);
    }
}