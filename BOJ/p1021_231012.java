import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class p1021_231012{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        // int[] arr = new int[m];
        // for(int i=0; i<m; i++){
        //     arr[i] = Integer.parseInt(str[i]);
        // }

        //덱 생성 후 1부터 n만큼 숫자 넣기
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++){
            deque.offer(i);
        }
        
        for(int i=0; i<m; i++){
            int target = Integer.parseInt(st.nextToken());
            int target_idx = deque.indexOf(target);
            int half_idx;

            if(deque.size() % 2 == 0){
                half_idx = deque.size() / 2 - 1;
            } else {
                half_idx = deque.size() / 2;
            }

            if(target_idx <= half_idx){
                // target_idx 보다 앞에 있는 원소들을 모두 뒤로 보냄
                for(int j=0; j < target_idx; j++){
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    cnt++;
                }
            }
            else{
                // target_idx 를 포함한 뒤에 있는 원소들을 모두 앞으로 보냄
                for(int j=0; j < deque.size() - target_idx; j++){
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        
        System.out.println(cnt);
    }
}