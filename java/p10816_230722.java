import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10816_230722 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        
        for(int i=0; i<m; i++){

        }
        
    }
}
=======
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p10816_230722{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            Integer cnt = map.get(num);
            if(cnt != null){
                map.put(num, cnt + 1);
            } else{
                map.put(num, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num)).append(" ");
            } else{
                sb.append("0").append(" ");
            }
            
        }
        System.out.println(sb);
        
    }
}
>>>>>>> b1cec5ec4e2c3e26d8ebc8064467da180d57d408
