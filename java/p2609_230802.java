import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2609_230802{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = GCD(Math.max(a, b), Math.min(a, b));
        long lcm = (a * b) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static long GCD(long a, long b){
        while(b!=0){
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}