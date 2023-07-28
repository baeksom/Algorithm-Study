import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1978_230728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(check(num)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean check(int num){
        if(num <= 1){
            return false;
        } else{
            for(int i=2; i*i <= num; i++){
                if(num%i == 0){
                    return false;
                }  
            }
            return true;
        }
    }
}
