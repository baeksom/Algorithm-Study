import java.util.*;
public class p1244_241115 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int sex = sc.nextInt();
			int button = sc.nextInt();
			
			if(sex == 1) { // 남
				for(int b=1; b<=n; b++) {
					if(b % button == 0) {
						arr[b] = (arr[b] + 1) % 2;
					}
				}
			} else {
				arr[button] = (arr[button] + 1) % 2;
				int d = 1;
				while(button-d >=0 && button+d <n) {
					if(arr[button+d] == arr[button-d]) {
						arr[button+d] = (arr[button+d] + 1) % 2;
						arr[button-d] = (arr[button-d] + 1) % 2;
						d++;
					}
					else {
						break;
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			sb.append(arr[i]).append(" ");
			if(i % 20 == 0) sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}