import java.util.*;
public class p9663_241116 {
	static int n, answer = 0;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dfs(0);
		System.out.println(answer);
	}
	
	public static void dfs(int L) {
		if(L == n) {
			answer++;
			return;
		}
		for(int i=0; i<n; i++) {
			arr[L] = i;
			if(isPossible(L)) {
				dfs(L+1);
			}
		}
	}
	
	public static boolean isPossible(int idx) {
		for(int i=0; i<idx; i++) {
			if(arr[i] == arr[idx] || idx-i == Math.abs(arr[i] - arr[idx])) {
				return false;
			}
		}
		return true;
	}
}