import java.util.*;
public class p11725_241112 {
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    public static void dfs(int node) {
        for(int n : graph.get(node)) {
            if(ch[n] == 0) {
                ch[n] = node;
                dfs(n);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ch = new int[n+1];
        ch[1] = 1;
        dfs(1);
        for(int i=2; i<=n; i++) {
            System.out.println(ch[i]);
        }
    }
}