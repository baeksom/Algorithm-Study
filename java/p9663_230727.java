import java.util.Scanner;

public class p9663_230727 {
    static int[] arr;
    static int n;
    static int cnt = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        nQueen(0);
        System.out.println(cnt);
    }
    public static void nQueen(int num){
        if(num == n){
            cnt++;
            return;
        }
        for(int i=0; i<n; i++){
            if(num == 0){
                arr[num] = i;
                nQueen(num+1);
            } else{
                if(i != arr[num-1] && Math.abs(i-arr[num-1]) != 1){
                    arr[num] = i;
                    nQueen(num+1);
                }
            }
        }
    }
}
