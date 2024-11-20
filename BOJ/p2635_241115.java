import java.util.*;
import java.io.*;
public class p2635_241115 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> al;
		ArrayList<Integer> answeral = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			al = new ArrayList<>();
			
			al.add(n);
			al.add(i);
			
			int first = n;
			int second = i;
			while(first - second >= 0) {
				int tmp = first - second;
				al.add(tmp);
				first = second;
				second = tmp;
			}
			
			if(al.size() > answeral.size()) {
				answeral = al;
			}
		}
		System.out.println(answeral.size());
		for(int i : answeral) System.out.print(i + " ");
		
	}
}