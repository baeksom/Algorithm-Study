import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9663_260406 {
    static int n, answer = 0;
    static int[] board;
    static void DFS(int row) {
        if(row == n) answer++;
        else {
            for(int col=0; col<n; col++) {
                if(isPossible(col, row)) {
                    board[row] = col;
                    DFS(row + 1);
                }
            }
        }
    }

    public static boolean isPossible(int col, int row) {
        for(int i=0; i<row; i++) {
            if(col == board[i]) return false;
            else if (Math.abs(row - i) == Math.abs(col - board[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n];
        
        DFS(0);
        System.out.println(answer);
    }
}