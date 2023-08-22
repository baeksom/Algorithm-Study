import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p2751_230716 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        //Collections.sort()은 Object type arrays에 대해 Merge Sort 보다 향상된 Tim Sort 를 수행한다.

        for(Integer i: list){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}