import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class p1026_230719 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());        

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += A[i] * B[i];
        }
        System.out.println(sum);
    }
}
