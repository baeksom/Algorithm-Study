// 안전한 지역을 카운트
// class Solution {
//     public int solution(int[][] board) {
//         int answer = 0;
//         int[] dr = {-1,-1,0,1,1,1,0,-1};
//         int[] dc = {0,1,1,1,0,-1,-1,-1};
//         int n = board.length;
//         for(int r=0; r<n; r++) {
//             for(int c=0; c<n; c++){
//                 boolean flag = true;
//                 if (board[r][c] == 0) {
//                     for(int i=0; i<8; i++) {
//                         int nr = r + dr[i];
//                         int nc = c + dc[i];
//                         if(nr >=0 && nr < n && nc >=0 && nc < n&& board[nr][nc] == 1) {
//                             flag = false;
//                             break;
//                         }
//                     }
//                 } else {
//                     flag = false;
//                 }
//                 if (flag) {
//                     answer++;
//                 }
//             }
//         }
//         return answer;
//     }
// }

// 안전하지 않은 지역을 카운트 (안전하지 않은 지역을 2로 변경)
class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = n*n;
        int[] dr = {-1,-1,0,1,1,1,0,-1};
        int[] dc = {0,1,1,1,0,-1,-1,-1};
        int cnt = 0;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(board[r][c] == 1){
                    cnt++;
                    for(int i=0; i<8; i++){
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if(nr >=0 && nr < n && nc >=0 && nc < n && board[nr][nc] == 0) {
                            cnt++;
                            board[nr][nc] = 2;
                        }
                    }
                }
            }
        }
        return answer-cnt;
    }
}