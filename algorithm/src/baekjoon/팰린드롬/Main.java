package baekjoon.팰린드롬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 팰린드롬? (문제번호 : 10942)
 * 
 * @category Dynamic Programming
 * @since 2016.11.16
 * @author dongha
 */
public class Main {
    static final int PAL = 1;
    static final int NON_PAL = 0;
 
    static int N;
    static int M;
    static int[] A;
    static int[][] D;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        D = new int[N][N];
        M = Integer.parseInt(br.readLine());
 
        init();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
 
            bw.write(String.valueOf(D[s][e])+"\n");
            bw.flush();
        }
        br.close();
        bw.close();
 
    }
 
    private static void init() {
        for (int i = 0; i < N; i++) {
            D[i][i] = PAL;
        }
        for (int i = 0; i < N - 1; i++) {
            if (A[i] == A[i + 1])
                D[i][i + 1] = PAL;
            else
                D[i][i + 1] = NON_PAL;
        }
        // ////////////////부분문제 해결//////////////////
 
        for (int s = N - 3; s >= 0; s--) {
            for (int e = N - 1; e >= 2; e--) {
                int ans = 0;
                if (A[s] == A[e])
                    ans = PAL;
                else
                    ans = NON_PAL;
                if(ans==PAL && D[s+1][e-1]==PAL)
                    D[s][e] = PAL;
            }
        }
    }
 
}