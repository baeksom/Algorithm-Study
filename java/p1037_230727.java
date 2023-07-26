import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1037_230727 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        if(n == 1){
            int num = Integer.parseInt(st.nextToken());
            System.out.println(num*num);
        }
        else{
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            if(n % 2 == 0){
                System.out.println(arr[0]*arr[n-1]);
            }
            else if(n % 2 == 1){
                System.out.println(arr[n/2]*arr[n/2]);
            }
        }
    }
}
