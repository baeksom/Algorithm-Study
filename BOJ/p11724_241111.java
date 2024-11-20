import java.util.*;

public class p11724_241111 {
    static int n, m;
    static int[][] graph;
    static int[] ch;
    public static void dfs(int v) {
        for(int i=1; i<=n; i++) { 
            if(graph[v][i] == 1 && ch[i] == 0) {// n에서 갈 수 있는 노드
                ch[i] = 1;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        ch = new int[n+1];
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(ch[i] == 0) {
                cnt++;
                ch[i] = 1;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }
}
