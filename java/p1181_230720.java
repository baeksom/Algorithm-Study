import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p1181_230720 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 개행문자 버리기

        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                } else{
                    return s1.length() - s2.length();
                }
            }            
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append('\n');
        for(int i=1; i<n; i++){
            if(!arr[i].equals(arr[i-1])){
                sb.append(arr[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
