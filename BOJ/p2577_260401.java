import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p2577_260401 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 1;
        for(int i=0; i<3; i++) {
            num *= Integer.parseInt(br.readLine());
        }

        int[] count = new int[10];
        while (num > 0) {
            int digit = num % 10;
            count[digit]++;
            num /= 10;
        }

        for(int i=0; i<10; i++) {
            System.out.println(count[i]);
        }
    }
}
