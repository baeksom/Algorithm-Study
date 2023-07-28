// 사과 num개를 a개를 담을 수 있는 박스,
// b개를 담을 수 있는 박스를 이용해 완전히 담으려고 한다.
// 최소 개수의 박스 수를 구해라.
//
// 첫째 줄 테스트 케이스
// 사과 개수 / a 박스가 담을 수 있는 개수 / b 박스가 담을 수 있는 개수
// 11 2 3
// -> 5
// 12 2 4
// -> 6

import java.util.Scanner;

public class scpc_round1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testcase = sc.nextInt();
        while(testcase-- > 0){
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
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
