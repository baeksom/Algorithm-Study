// 스택이 비어있을 때 ")"가 들어오면 바로 NO로 끝내야함
import java.io.*;
import java.util.*;

public class p9012_260402 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            Deque<Integer> q = new ArrayDeque<>();
            String str = br.readLine().trim();
            boolean flag = true;
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == '(') {
                    q.push(1);
                } 
                else if (str.charAt(i) == ')' && !q.isEmpty()) {
                    q.pop();
                }
                else {
                    flag = false;
                    break;
                }
            } 
            if(q.isEmpty() && flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}
