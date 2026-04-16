import java.io.*;
import java.util.*;

public class p2606_260416 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int nextInt() throws IOException {
        if(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    static int n, m, ans = 0;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] ch;
    static void dfs(int s) {
        ch[s] = 1;
        ans++;
        for(int i : arr.get(s)) {
            if(ch[i] == 0) {
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        ch = new int[n+1];
        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            int x = nextInt();
            int y = nextInt();
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        dfs(1);
        
        System.out.println(ans-1);
    }
}
