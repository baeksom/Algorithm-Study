import java.util.Scanner;

public class p10866_230718 {
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
                case "push_front":
                    int num1 = sc.nextInt();
                    push_front(num1);
                    break;
                case "push_back":
                    int num2 = sc.nextInt();
                    push_back(num2);
                    break;
                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(pop_back()).append("\n");
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
    public static void push_front(int n){
        if(size > 0){
            for(int i=size; i>0; i--){
                stack[i] = stack[i-1];
            }
        }
        stack[0] = n;
        size++;
    }
    public static void push_back(int n){
        stack[size] = n;
        size++;
    }
    public static int pop_front(){
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
    public static int pop_back(){
        if(size == 0){
            return -1;
        } else{
            int popN = stack[size-1];
            stack[size-1] = 0;
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
