import java.util.Scanner;

public class p1929_230728{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        int n = sc.nextInt();
        for(int i = m; i <= n; i++){
            if(check(i)) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
    public static boolean check(int num){
        if(num < 2){
            return false;
        }
        else{
            for(int i=2; i*i<=num; i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}