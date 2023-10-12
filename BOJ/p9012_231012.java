import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p9012_231012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            String str = br.readLine();
            
            if(check(str)) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
    
    public static boolean check(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else if(c == ')' && !stack.isEmpty()){
                stack.pop();
            }
            else{
                return false;
            }
        }

        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
