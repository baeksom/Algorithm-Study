import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			HashMap<Integer, Integer> map = new HashMap<>();
            sc.nextInt();
            for(int i=0; i<1000; i++) {
                int a = sc.nextInt();
                map.put(a, map.getOrDefault(a, 0)+1);
            }
            ArrayList<Integer> al = new ArrayList<>();
            int maxValue = 0;
            for(int v: map.values()) {
                if(v > maxValue) {
                    maxValue = v;
                }
            }
            for(int key: map.keySet()) {
                if(map.get(key) == maxValue) al.add(key); 
            }

            System.out.println("#" + test_case + " "+ Collections.max(al));
		}
	}
}