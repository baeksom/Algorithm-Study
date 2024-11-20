import java.util.*;
import java.io.*;
class Germ implements Comparable<Germ> {
	int num;
	int x, y;
	int cnt;
	int dir;
	Germ(int num, int x, int y, int cnt, int dir) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.dir = dir;
	}
	
	@Override
	public int compareTo(Germ ob) {
		if(this.num == ob.num) {
			return ob.cnt - this.cnt;
		}
		return this.num - ob.num;
	}
}
class p2382
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			ArrayList<Germ> al = new ArrayList<>();
			
			int[] dx = {0,-1,1,0,0};
			int[] dy = {0,0,0,-1,1};
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				al.add(new Germ(x*n+y, x, y, cnt, dir));
			}
			
			for(int t=0; t<m; t++) {
				// 이동
				for(int idx=0; idx<al.size(); idx++) {
					Germ germ = al.get(idx);
					germ.x = germ.x + dx[germ.dir];
					germ.y = germ.y + dy[germ.dir];
					germ.num = (germ.x * n) + germ.y;
					
					// 약품 : 미생물 군집이 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물 절반이 죽고, 이동방향이 반대로 바뀐다.
					if(germ.x == 0 || germ.y == 0 || germ.x == n-1 || germ.y == n-1) {
						germ.cnt /= 2;
						germ.dir = changeDir(germ.dir);
						if(germ.cnt == 0) {
							al.remove(idx);
							idx--;
						}
					}
				}
				
				Collections.sort(al);
				
				// 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다.
				for(int idx = 0; idx < al.size()-1; idx++) {
					Germ now = al.get(idx);
					Germ next = al.get(idx+1);
					
					if(now.num == next.num) {
						now.cnt += next.cnt;
						al.remove(idx + 1);
						idx--;
					}
				}
			}
			
			int total = 0;
			for(int i=0; i<al.size(); i++) {
				total += al.get(i).cnt;
			}
			System.out.println("#" + test_case + " " + total);
			
		}
	}
	public static int changeDir(int dir) {
		switch(dir) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return -1;
	}
}