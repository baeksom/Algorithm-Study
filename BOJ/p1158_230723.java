import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1158_230723 {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int k = sc.nextInt();
    //     Queue<Integer> queue = new LinkedList<>();
    //     for(int i=0; i<n; i++){
    //         queue.add(i+1);
    //     }

    //     StringBuffer sb = new StringBuffer();
    //     sb.append("<");
    //     while (queue.size() != 1) {
    //         for(int i=0; i<k-1; i++){
    //             queue.add(queue.poll());
    //         }
    //         int num = queue.poll();
    //         sb.append(num).append(", ");
    //     }
    //     sb.append(queue.poll()).append(">");

    //     System.out.println(sb);
    // }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int time = Integer.parseInt(input[1]);
        Queue<Integer> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        
        for(int i=0; i<num; i++){
            queue.add(i+1);
        }

        while(queue.size() != 1){
            for(int i=0; i<time-1; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }   
}
