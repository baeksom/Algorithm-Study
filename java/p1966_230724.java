import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1966_230724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int testCase = sc.nextInt();

        while(testCase-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            LinkedList<int[]> queue = new LinkedList<>();
            for(int i=0; i<n; i++){
                queue.add(new int[]{i,sc.nextInt()});
            }

            int count = 0;
            while(!queue.isEmpty()){
                int[] front = queue.poll();
                boolean check = false;

                for(int i=0; i<queue.size(); i++){
                    if(front[1] < queue.get(i)[1]){
                        queue.add(front);
                        for(int j=0; j<i; j++){
                            queue.add(queue.poll());
                            break;
                        }
                    }
                }

                if(check == false)
                    continue;
                
                count++;
                if(front[0] == m)
                    break;
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
