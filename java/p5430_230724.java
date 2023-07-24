import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p5430_230724 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException{
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for(int i=0; i<n; i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(cmd, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String command, ArrayDeque<Integer> deque){
        boolean startLeft = true;

        for(char cmd : command.toCharArray()){
            if(cmd == 'R'){
                startLeft = !startLeft;
                continue;
            } 

            if(cmd == 'D'){
                if(startLeft){
                    // 왼쪽부터 시작 : 왼->오
                    if(deque.pollFirst() == null){
                        sb.append("error\n");
                        return;
                    }
                }
                else{
                    // 오른쪽부터 시작 : 오->왼
                    if(deque.pollLast() == null){
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }
        makeString(startLeft, deque);
    }

    public static void makeString(boolean startLeft, ArrayDeque<Integer> deque){
        sb.append('[');
        if(deque.size() > 0){
            if(startLeft){
                sb.append(deque.pollFirst());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollFirst());
                }
            }
            else{
                sb.append(deque.pollLast());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollLast());
                }
            }
        }
        sb.append("]\n");
    }
}
