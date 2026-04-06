import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p14888_260407 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int nextInt() throws IOException{
        if(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    static int n;
    static int[] arr, ch;
    static ArrayList<Character> sign;
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    static void DFS(int L, int sum) {
        if(L == sign.size() + 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        else {
            for(int i=0; i<sign.size(); i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    switch (sign.get(i)) {
                        case '+':
                            DFS(L+1, sum+arr[L]);
                            break;
                        case '-':
                            DFS(L+1, sum-arr[L]);
                            break;
                        case '*':
                            DFS(L+1, sum*arr[L]);
                            break;
                        case '/':
                            DFS(L + 1, sum / arr[L]);
                            break;
                        default:
                            break;
                    }
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        n = nextInt();
        arr = new int[n];
        sign = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr[i] = nextInt();
        }

        int x = nextInt();
        while (x-- > 0) {
            sign.add('+');
        }

        x = nextInt();
        while (x-- > 0) {
            sign.add('-');
        }

        x = nextInt();
        while (x-- > 0) {
            sign.add('*');
        }

        x = nextInt();
        while (x-- > 0) {
            sign.add('/');
        }

        ch = new int[sign.size()];
        DFS(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}