import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9095_230726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        while(n-- >0){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            if(num <= 0){
                sb.append(0).append('\n');
            } else if(num == 1){
                sb.append(1).append('\n');
            } else if(num == 2){
                sb.append(2).append('\n');
            } else if(num == 3){
                sb.append(4).append('\n');
            } else{
                arr[0] = 1;
                arr[1] = 2;
                arr[2] = 4; 
                for(int i=3; i<num; i++){
                    arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
                }
                sb.append(arr[num-1]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
