import java.util.*;
import java.io.*;
public class p2116_241115 {
	static int n;
	static int answer = 0;
	static ArrayList<int[]> al;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			al.add(new int[] {a,b,c,d,e,f});
		}
		
		int start = 0;
		for(int i=0; i<6; i++) {
			int curUp = al.get(0)[i];
			
			if(i == 0 || i == 5) {
				start = findMaxWithoutAandB(0,5,al.get(0));
			} else if(i == 1 || i == 3) {
				start = findMaxWithoutAandB(1,3,al.get(0));
			} else if(i == 2 || i == 4) {
				start = findMaxWithoutAandB(2,4,al.get(0));
			}
			
			dfs(curUp, 1, start);
		}
		
		System.out.println(answer);
	}
	
	public static int findMaxWithoutAandB(int a, int b, int[] arr) {
		int max = 0;
		for(int i=0; i<6; i++) {
			if(i != a && i != b) {
				max = Math.max(max, arr[i]);
			}
		}
		return max;
	}
	
	public static void dfs(int bottom, int L, int sum) {
		if(L == n) {
			answer = Math.max(answer, sum);
		}
		else {
			int[] cur = al.get(L); // 현재 주사위
			for(int i=0; i<6; i++) {
				if(cur[i] == bottom) {
					if(i == 0 || i == 5) {
						dfs(i==0?cur[5]:cur[0], L+1, sum+findMaxWithoutAandB(0,5,cur));
					} else if(i == 1 || i == 3) {
						dfs(i==1?cur[3]:cur[1], L+1, sum+findMaxWithoutAandB(1,3,cur));
					} else if(i == 2 || i == 4) {
						dfs(i==2?cur[4]:cur[2], L+1, sum+findMaxWithoutAandB(2,4,cur));
					}
				}
			}
		}
	}
}
// a - f / b - d / c - e
// a b c d e f
// 0 - 5 / 1 - 3 / 2 - 4