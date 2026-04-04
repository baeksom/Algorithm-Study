import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15649_260405 {
    static int[] ch, box;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static void DFS(int L) {
        if(L == m) {
            for(int i=0; i<m; i++) {
                sb.append(box[i]).append(" ");
            }
            sb.append('\n');
        }
        else {
            for(int i=1; i<=n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    box[L] = i;
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[n+1];
        box = new int[m];

        DFS(0);
        System.out.println(sb.toString());
    }
}
