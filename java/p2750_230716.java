import java.util.Scanner;
import java.util.Arrays;

public class p2750_230716 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}