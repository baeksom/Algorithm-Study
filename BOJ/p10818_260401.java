import java.io.*;
import java.util.*;

public class p10818_260401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        if(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String agrs[]) throws Exception {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nextInt();
        for(int i=0; i<n ;i++) {
            int x = nextInt();
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        System.out.println(min + " " + max);
    }
}