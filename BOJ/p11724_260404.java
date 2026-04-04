import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p11724_260404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int nextInt() throws IOException {
        if(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static int answer = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    static void DFS(int v) {
        for(int i : graph.get(v)) {
            if(ch[i] == 0) {
                ch[i] = 1;
                DFS(i);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        int n = nextInt();
        int m = nextInt();
        ch = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        while (m-- > 0) {
            int x = nextInt();
            int y = nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i=1; i<=n; i++) {
            if(ch[i] == 0) {
                answer++;
                ch[i] = 1;
                DFS(i);
            }
        }

        System.out.println(answer);
    }    
}
