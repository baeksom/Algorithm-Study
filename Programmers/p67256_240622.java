class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10, right = 11; // * - 10 / # - 11 
        // 자판 별로 거리 차 구하기
        int[][] dist = {{0,0,3,0,0,2,0,0,1,0,0,0},
                        {4,0,1,0,0,2,0,0,3,0,0,0},
                        {3,0,0,0,0,1,0,0,2,0,0,0},
                        {4,0,1,0,0,2,0,0,3,0,0,0},
                        {3,0,2,0,0,1,0,0,2,0,0,0},
                        {2,0,1,0,0,0,0,0,1,0,0,0},
                        {3,0,2,0,0,1,0,0,2,0,0,0},
                        {2,0,3,0,0,2,0,0,1,0,0,0},
                        {1,0,2,0,0,1,0,0,0,0,0,0},
                        {2,0,3,0,0,2,0,0,1,0,0,0},
                        {1,0,4,0,0,3,0,0,2,0,0,0},
                        {1,0,4,0,0,3,0,0,2,0,0,0}};
        StringBuilder sb = new StringBuilder();
        
        for(int n : numbers) {
            if(n==1 || n==4 || n==7) {
                sb.append('L');
                left = n;
            } else if (n==3 || n==6 || n==9) {
                sb.append('R');
                right = n;
            } else {
                if (dist[left][n] > dist[right][n]) {
                    sb.append('R');
                    right = n;
                } else if (dist[left][n] < dist[right][n]) {
                    sb.append('L');
                    left = n;
                } else if (hand.equals("right")) {
                    sb.append('R');
                    right = n;
                } else {
                    sb.append('L');
                    left = n;
                }
            }
        }
        return sb.toString();
    }
}