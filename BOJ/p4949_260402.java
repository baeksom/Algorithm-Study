import java.util.*;
import java.io.*;

public class p4949_260402 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            }

            Deque<Integer> q = new ArrayDeque<>();
            for(char c : str.toCharArray()) {
                if (c == '.') {
                    if(q.isEmpty()) sb.append("yes\n");
                    else sb.append("no\n");
                    break;
                }else if(c == '(') {
                    q.push(1);
                } else if (c == '[') {
                    q.push(2);
                } else if (c == ')') {
                    if(!q.isEmpty() && q.peek() == 1) {
                        q.pop();
                    }
                    else {
                         sb.append("no\n");
                         break;
                    }
                }
                else if (c == ']') {
                    if(!q.isEmpty() && q.peek() == 2) {
                        q.pop();
                    }
                    else {
                         sb.append("no\n");
                         break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
