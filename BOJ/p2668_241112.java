import java.util.*;
import java.io.*;
public class p2668_241112 {
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		visited = new boolean[n+1];
		answer = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i : answer) System.out.println(i);		
	}
	
	static void dfs(int start, int target) {
		if(!visited[arr[start]]) {
			visited[start] = true;
			dfs(arr[start], target);
			visited[start] = false;
		}
		if(arr[start] == target) {
			answer.add(target);
		}
	}
}