import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6603_230726 {
    public static StringBuffer sb = new StringBuffer();
    public static int n;
    public static int[] arr; // 사용자에게 입력받은 숫자를 저장하는 배열
    public static int[] tmp = new int[6];
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            
            n = Integer.parseInt(st.nextToken());
            if(n == 0){
                break;
            }

            arr = new int[n];
            visited = new boolean[n+1];
            
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            recursion(0, 1);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void recursion(int index, int start){
        if(index == 6){
            for(int i: tmp){
                sb.append(arr[i-1]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=start; i<=n; i++){
            tmp[index] = i;
            visited[i] = true;
            recursion(index+1, i+1);
            visited[i] = false;
        }
    }
}
