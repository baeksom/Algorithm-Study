import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p5397_230922{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ans = new String[n];

        for(int k=0; k<n; k++){
            String str = br.readLine();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '<'){
                    if(leftStack.isEmpty())
                        continue;
                    rightStack.push(leftStack.pop());
                } else if(str.charAt(i) == '>'){
                    if(rightStack.isEmpty())
                        continue;
                    leftStack.push(rightStack.pop());
                } else if(str.charAt(i) == '-'){
                    if(leftStack.isEmpty())
                        continue;
                    leftStack.pop();
                } else{
                    leftStack.push(str.charAt(i));
                }
            }

            while(!leftStack.isEmpty()){
                rightStack.push(leftStack.pop());
            }
            StringBuffer sb = new StringBuffer();
            while(!rightStack.isEmpty()){
                sb.append(rightStack.pop());
            }

            ans[k] = sb.toString();
        }

        for(String k : ans){
            System.out.println(k);
        }
    }
}