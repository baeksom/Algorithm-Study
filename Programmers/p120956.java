class Solution {
    public static String[] al = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String ba : babbling){
            for(String str : al){
                ba = ba.replaceFirst(str, " ");
            }
            if(ba.replaceAll(" ","").equals("")) answer++;
        }
        return answer;
    }
}