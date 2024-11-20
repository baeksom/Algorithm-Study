import java.util.*;
public class p2606_241109 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public static void dfs(int node) {
        for(int n : graph.get(node)) { // node에서 갈수있는 정점
            if(ch[n] == 0) {
                ch[n] = 1;
                dfs(n);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        graph = new ArrayList<>();
        ch = new int[node+1];
        for(int i=0; i<=node ;i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        int answer = 0;
        for(int i=0; i<=node; i++) {
            if(ch[i] == 1) answer++;
        }
        System.out.println(answer);
    }
}
