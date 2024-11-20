import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int dumpCnt = sc.nextInt();
			ArrayList<Integer> al = new ArrayList<>();
			for(int i=0; i<100; i++) {
				al.add(sc.nextInt());
			}
			
			Collections.sort(al, Collections.reverseOrder());
			for(int i=0; i<dumpCnt; i++) {
				al.set(0, al.get(0) -1);
				al.set(99, al.get(99) +1);
				Collections.sort(al, Collections.reverseOrder());
			}
			
			System.out.println("#" + test_case + " " + (al.get(0) - al.get(99)));
		}
	}
}