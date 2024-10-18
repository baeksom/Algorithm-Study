/*
ch 배열로 이미 네트워크로 센 컴퓨터인지 확인
DFS에서 첫 컴퓨터와 연결된 컴퓨터는 모두 0으로 바꿈
 */
class Solution {
    static int[] ch;
    public void DFS(int L, int[][] computers, int n) {
        for(int i=0; i<n; i++) {
            if(computers[i][L] == 1 && ch[i] == 0) {
                ch[i] = 1;
                computers[i][L] = 0;
                computers[L][i] = 0;
                DFS(i, computers, n);
            }
        }
    } 
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ch = new int[n];
        for(int i=0; i<n; i++) {
            if(ch[i] == 0) {
                answer++;
                ch[i] = 1;
                DFS(i, computers, n);
            }
        }
        return answer;
    }
}