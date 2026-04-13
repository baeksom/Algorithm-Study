import java.io.*;
import java.util.*;

public class p1260_260413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int nextInt() throws IOException {
        if(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    static int n, m , v;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] ch;
    static void dfs(int cur) {
        sb.append(cur).append(" ");
        ch[cur] = 1;
        for(int next : arr.get(cur)) {
            if(ch[next] == 0) {
                dfs(next);
            }
        }
    }
    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        ch = new int[n+1];
        
        // 시작 지점
        q.add(v);
        ch[v] = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                int cur = q.poll();
                sb.append(cur).append(" ");
                for(int next : arr.get(cur)) {
                    if(ch[next] == 0) {
                        ch[next] = 1;
                        q.offer(next);
                    }
                }
            }         
        }
    }
    public static void main(String[] args) throws Exception{
        n = nextInt();
        m = nextInt();
        v = nextInt();
        for(int i=0; i<n+1; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++) {
            // 간선 저장
            int a = nextInt();
            int b = nextInt();
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        arr.forEach(Collections::sort);

        ch = new int[n+1];
        dfs(v);
        sb.append('\n');
        bfs();

        System.out.println(sb.toString());
    }
}
