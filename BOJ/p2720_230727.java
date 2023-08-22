import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2720_230727 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        while(n-- >0){
            int coin = Integer.parseInt(br.readLine());
            sb.append(coin/25).append(" ");
            coin %= 25;
            sb.append(coin/10).append(" ");
            coin %= 10;
            sb.append(coin/5).append(" ");
            coin %= 5;
            sb.append(coin).append('\n');
        }
        System.out.println(sb);
    }
}
