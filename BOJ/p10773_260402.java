import java.util.*;
import java.io.*;

public class p10773_260402 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                q.pop();
            } 
            else q.push(x);
        }

        int sum = 0;
        while (!q.isEmpty()) {
            sum += q.pop();
        }
        System.out.println(sum);
    }
}
