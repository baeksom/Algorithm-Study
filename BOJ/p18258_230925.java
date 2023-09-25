import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        int last = 0;

        while(n-- >0){
            String[] str = br.readLine().split(" ");
            String cmd = str[0];

            switch(cmd){
                case "push":
                    int num = Integer.parseInt(str[1]);
                    queue.add(num);
                    last = num;
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(queue.poll()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(queue.peek()).append('\n');
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(last).append('\n');
                    }    
            }
        }
        System.out.println(sb);
    }
}
