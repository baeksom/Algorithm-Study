import java.util.Scanner;
import java.util.Stack;

public class p1874_230723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        while(n-- >0){
            int value = sc.nextInt();

            if(value > start){
                for(int i=start+1; i<= value; i++){
                    stack.push(i);
                    sb.append("+").append('\n');
                }
                start = value;
            }
            else if(stack.peek() != value){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append('\n');
        }
        System.out.println(sb);

    }
}
