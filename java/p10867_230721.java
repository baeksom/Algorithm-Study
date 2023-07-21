import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p10867_230721 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for(int i=0; i<n; i++){
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>(hashSet);
        Collections.sort(arrayList);
        
        StringBuilder sb = new StringBuilder();
        for(int i: arrayList){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
