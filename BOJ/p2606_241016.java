import java.util.*;
public class Main {
    static ArrayList<ArrayList<Integer>> al;
    static int node, edge, answer;
    static int[] ch;
    public void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        ch[1] = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                int c = q.poll();
                for(int nx : al.get(c)) {
                    if(ch[nx] == 0) {
                        ch[nx] = 1;
                        q.offer(nx);
                        answer++;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        node = sc.nextInt();
        edge = sc.nextInt();
        al = new ArrayList<>();
        ch = new int[node+1];
        for(int i=0; i<=node; i++) {
            al.add(new ArrayList<>());
        }
        for(int i=0; i<edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            al.get(a).add(b);
            al.get(b).add(a);
        }
        T.BFS();
        System.out.println(answer);
    }
}
