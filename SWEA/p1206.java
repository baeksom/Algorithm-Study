import java.util.Scanner;

class Solution
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int answer = 0;
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=2; i<n-3; i++) {
				int cur = arr[i];
				int leftMax = Math.max(arr[i-2], arr[i-1]);
				int rightMax = Math.max(arr[i+1], arr[i+2]);
				if(cur > leftMax && cur > rightMax) {
					answer += (cur - Math.max(leftMax, rightMax));
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
}