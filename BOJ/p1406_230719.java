import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1406_230719 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> lefStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            lefStack.push(str.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String command = br.readLine();
            switch(command.charAt(0)){
                case 'L':
                    if(lefStack.empty())
                        break;
                    rightStack.push(lefStack.pop());
                    break;
                case 'D':
                    if(rightStack.empty())
                        break;
                    lefStack.push(rightStack.pop());
                    break;
                case 'B':
                    if(lefStack.empty())
                        break;
                    lefStack.pop();
                    break;
                case 'P':
                    lefStack.push(command.charAt(2));
                    break;
            }
        }
        while(!lefStack.empty()){
            rightStack.push(lefStack.pop());
        }
        StringBuffer sb = new StringBuffer();
        while(!rightStack.empty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb.toString());
    }
}
