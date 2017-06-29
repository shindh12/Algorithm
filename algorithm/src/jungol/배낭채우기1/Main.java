package jungol.배낭채우기1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * 배낭채우기 1 (문제번호 : 1077)
 * 
 * @category Dynamic Programming
 * @since 2016.11.10
 * @author dongha
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                System.out));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] w = new int[N]; // w[i]는 i번째 보석의 무게
        int[] p = new int[N]; // p[i]는 i번째 보석의 값어치
        int[][] D = new int[N][W + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        for (int i = w[0]; i <= W; i++) {
            D[0][i] = D[0][i - w[0]] + p[0];
        }
 
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                int pick = -1;
                if(j>=w[i]) pick = D[i][j-w[i]] + p[i];
                int nopick = D[i-1][j];
                 
                D[i][j] = Math.max(pick, nopick);
            }
        }
        bw.write(String.valueOf(D[N-1][W]));
        bw.flush();
        bw.close();
    }
}