import java.util.Scanner;

public class scpc_round1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int cnt = 0;
        boolean check = false;

        if(num % min == 0){
            cnt = num / min;
        }
        else {
            while(!check){
                num -= max;
                cnt++;
                if(num % min == 0){
                    cnt += num / min;
                    check = true;
                }
            }
        }

        System.out.println(cnt);
    }
}
