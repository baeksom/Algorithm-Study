/*
 * n==0 일 때 상근이가 돌 못 가져감 => false
 * n==1 일 때 상근이가 돌 가져갈 수 있음 => true
 * n==2 일 때 창영이가 돌 가져감 => false
 * n==3 일 때 상근이가 돌 가져감 => true
 * 따라서 n이 홀수일 때 상근이가 이기고, 짝수일 때 창영이가 이김
 */
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        bw.write((n % 2 == 1) ? "SK" : "CY");
        bw.flush(); 
    }
}