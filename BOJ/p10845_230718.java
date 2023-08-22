import java.util.Scanner;

public class p10845_230718 {
    public static int[] stack;
    public static int size = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        stack = new int[n];
        
        for(int i=0; i<n; i++){
            String str = sc.next();
            switch(str){
                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
    public static void push(int n){
        stack[size] = n;
        size++;
    }
    public static int pop(){
        if(size == 0){
            return -1;
        } else{
            int popN = stack[0];
            for(int i=0; i<size; i++){
                stack[i] = stack[i+1];
            }
            size--;
            return popN;
        }
    }
    public static int empty(){
        if(size == 0){
            return 1;
        } else{
            return 0;
        }
    }
    public static int front(){
        if(size == 0){
            return -1;
        } else{
            return stack[0];
        }
    }
    public static int back(){
        if(size == 0){
            return -1;
        } else{
            return stack[size-1];
        }
    }
}
