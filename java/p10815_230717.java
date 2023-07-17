import java.util.Scanner;
import java.util.Arrays;

public class p10815_230717 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int num = sc.nextInt();
            int left = 0;
            int right = arr.length - 1;
            boolean check = false;

            while(left <= right){
                int mid = (right+left) / 2;
                if(num < arr[mid]){
                    right = mid -1;
                } else if (num > arr[mid]){
                    left = mid +1;
                } else{
                    check = true;
                    break;
                }
            }

            if(check){
                sb.append(1+" ");
            } else{
                sb.append(0+" ");
            }
        }

        System.out.println(sb);
    }
}
