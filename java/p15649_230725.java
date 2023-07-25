import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15649_230725 {
    public static StringBuffer sb = new StringBuffer();
    public static int n, m;
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1];
        visited = new boolean[n+1];

        recursion(0);
        System.out.println(sb);
    }
    public static void recursion(int index){
        if(index == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                arr[index] = i;
                visited[i] = true;
                recursion(index+1);
                visited[i] = false;
            }
        }
    }
}
