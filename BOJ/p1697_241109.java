import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int bfs(int start, int end) {
        if(start == end) return 0;
        Queue<Integer> q = new LinkedList<>();
        int[] time = new int[100001];
        q.offer(start);
        // time[start] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] next = {cur-1, cur+1, cur*2};

            for(int n : next) {
                if(n == end) return time[cur] + 1;
                if(n >= 0 && n < 100001 && time[n] == 0) {
                    q.offer(n);
                    time[n] = time[cur] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n, k));
    }
}