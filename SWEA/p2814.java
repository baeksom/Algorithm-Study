import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int vertex, answer;
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            graph = new ArrayList<>();
            answer = 0;
            vertex = sc.nextInt();
            int edge = sc.nextInt();
            ch = new int[vertex+1];
            if(edge == 0) {
                System.out.println("#" + test_case + " 1");
                continue;
            }
            for(int i=0; i<=vertex; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i =0 ; i<edge; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for(int i=1; i<=vertex; i++) { // 모든 노드가 시작 노드가 될 수 있도록 탐색
                ch[i] = 1;
                dfs(i, 1); // 첫 노드부터 포함하므로 길이는 1
                ch[i] = 0;
            }
            System.out.println("#" + test_case + " " + answer);
		}
        
	}
    public static void dfs(int node, int sum) {
        answer = Math.max(answer, sum);
        for(int i : graph.get(node)) {
            // node에서 갈 수 있는 정점
            if(ch[i] == 0) {
                ch[i] = 1;
                dfs(i, sum+1);
                ch[i] = 0;
            }
        }           
    }
}
