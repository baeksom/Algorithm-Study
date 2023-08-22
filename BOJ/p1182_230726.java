import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1182_230726 {
    static int n, s;
    static int[] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0,0);
        System.out.println(ans);
    }

    public static void DFS(int i, int cnt){
        if(i == n){
            return;
        } else{
            if(arr[i] + cnt == s){
                ans++;
            }

            DFS(i+1, cnt);
            DFS(i+1, cnt + arr[i]);
        }
    }
}
