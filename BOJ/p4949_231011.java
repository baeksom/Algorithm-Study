import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p4949_231011 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();

            if(str.equals(".")){
                break;
            }

            if(check(str)){
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }

        System.out.println(sb);

    }

    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for(char i : str.toCharArray()){
            if(i == '(' || i == '['){
                    stack.add(i);
            }
            else if(i == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else{
                    return false;
                }
            }
            else if(i == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                } else{
                    return false;
                }
            }
            else if(i == '.'){
                break;
            }
        }

        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
