package jungol.±ÿ¿Â¡¬ºÆ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * ±ÿ¿Â ¡¬ºÆ (πÆ¡¶π¯»£ : 1848)
 * 
 * @category Dynamic Programming
 * @since 2016.10.27
 * @author dongha
 */
public class Main {
    static final int MAX = 41;
    static int[] C; // ∞Ì¡§ºÆ
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        C = new int[M];
        for (int i = 0; i < M; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        int[] D = new int[MAX];
        D[1] = 1;
        D[2] = 2;
        for (int i = 3; i < MAX; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }
        int current = 0;
        int Answer = 1;
        for (int i = 0; i < M; i++) {
            int diff = C[i] - current - 1;
            current = C[i];
            if(diff==0) diff = 1;
            Answer *= D[diff];
        }
        if(N!=current) Answer *= D[N - current];
        System.out.println(Answer);
    }
}