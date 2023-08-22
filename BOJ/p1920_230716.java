import java.util.Scanner;
import java.util.Arrays;

public class p1920_230716 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int left = 0;
            int right = arr.length - 1;
            boolean flag = false;
            while (left <= right) {
                int midIdx = (left + right) / 2;
                int midValue = arr[midIdx];
                if (midValue > num) {
                    right = midIdx - 1;
                } else if (midValue < num) {
                    left = midIdx + 1;
                } else {
                    flag = true;
                    System.out.println(1);
                    break;
                }
            }
            if (!flag) {
                System.out.println(0);
            }
        }
    }
}