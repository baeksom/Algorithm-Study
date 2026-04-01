import java.io.*;

public class p2562_260401 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int idx = 0;
        for(int i=1; i<=9; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x > max) {
                max = x;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}