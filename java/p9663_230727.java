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
            arr[num] = i;
            if(check(num)){
                nQueen(num+1);
            }
        }
    }
    public static boolean check(int col){
        for(int i=0; i<col; i++){
            if(arr[i] == arr[col]){
                // 행이 같을 때
                return false;
            }
            else if(Math.abs(arr[i] - arr[col]) == Math.abs(i - col)){
                // 대각선이 겹칠 때 (행의 차와 열의 차가 같을 때)
                return false;
            }
        }
        return true;
    }
}
