import java.util.*;

public class p2644_241111 {
    static int n, m, start, end, cnt;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public static void dfs(int n, int sum) {
        if(n == end) {
            cnt = sum;
        }
        else {
            for(int i : graph.get(n)) { // 촌수로 갈 수 있는 방법
                if(ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i, sum+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ch = new int[n+1];
        dfs(start, 0);
        if (cnt == 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}
