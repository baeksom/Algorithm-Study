import java.util.Scanner;

public class p10828_230717 {
    public static int[] stack;
    public static int size = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        stack = new int[n];

        for(int i=0; i<n; i++){
            String str = sc.next();
            //next는 공백 전까지 nextline은 엔터까지

            switch(str){
                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
    //size는 스택 사이즈, size-1는 인덱스
    public static void push(int x){
        stack[size] = x;
        size++;
    }

    public static int pop() {
        if(size ==0){
            return -1;
        } else{
            int num = stack[size-1];
            stack[size-1] = 0;
            size--;
            return num;
        }
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0){
            return 1;
        } else{
            return 0;
        }
    }

    public static int top(){
        if(size == 0){
            return -1;
        } else{
            return stack[size-1];
        }
    }
}