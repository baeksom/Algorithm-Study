import java.util.*;
public class Main {
    static int n, m, p, s;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> al;
    public int BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(p);
        ch[p] = 1;
        int L = 0;
        
        while (!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                int cur = q.poll();
                for(int j : al.get(cur)) {
                    if(j==s) return ++L;
                    if(ch[j] == 0) {
                        ch[j] = 1;
                        q.offer(j);
                    }
                }
            }
            L++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        m = sc.nextInt();
        al = new ArrayList<>();
        ch = new int[n+1];
        for(int i=0; i<=n; i++) {
            al.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            al.get(x).add(y);
            al.get(y).add(x);
        }
        if(a>b) {p=b; s=a;}
        else {s=b; p=a;}
        System.out.println(T.BFS());
    }
    
}