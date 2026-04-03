/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class p18258_260403 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    q.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.pollFirst()).append('\n');
                    break;
                case "size":
                    sb.append(q.size() + "\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? "1" : "0").append('\n');
                    break;
                case "front":
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.peekFirst()).append('\n');
                    break;
                case "back":
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
