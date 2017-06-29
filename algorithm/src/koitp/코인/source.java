package koitp.코인;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * COIN
 * 
 * @category Dynamic Programming
 * @since 2016.11.14
 * @author dongha
 */
public class source {
    static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] D; // 캐시
        int[] C; // 동전의 종류
        int N = Integer.parseInt(br.readLine());
        C = new int[N];
        String[] coins = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(coins[i]);
        }
        int W = Integer.parseInt(br.readLine());
        br.close();
        D = new int[N][W + 1];
 
        // 초기화
        for (int w = C[0]; w <= W; w += C[0]) {
            D[0][w] = D[0][w - C[0]] + 1;
        }
 
        for (int i = 1; i < N; i++) {
            for (int w = 1; w <= W; w++) {
                int pick = INF;
                int nopick = D[i-1][w];
                if(w >= C[i]) pick = D[i][w-C[i]] + 1;
                if(nopick==0) nopick = INF;
                D[i][w] = Math.min(pick, nopick);
            }
        }
 
        int Answer = D[N-1][W];
        bw.write(String.valueOf(Answer));
//      bw.write(Answer==INF ? "impossible" : String.valueOf(Answer));
        bw.flush();
        bw.close();
    }
}