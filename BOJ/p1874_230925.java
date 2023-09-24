import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1874_230925 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int ch = 0;

        while(n-- >0){
            int target = Integer.parseInt(br.readLine());
            
            if(target > ch){
                for(int i=ch+1; i<= target; i++){
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                ch = target;
            }
            else if(stack.peek() != target){
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            stack.pop();
            sb.append('-').append('\n');            
        }
        System.out.println(sb);
    }
}
