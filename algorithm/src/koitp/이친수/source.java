package koitp.ÀÌÄ£¼ö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Pinary
 * 
 * @category Dynamic Programming
 * @since 2016.12.04
 * @author dongha
 */

public class source {
    static final int ZERO = 0;
    static final int ONE = 1;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                System.out));
        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[N + 1][2];
        // D[1][ZERO] = 0;
        D[1][ONE] = 1;
 
        for (int i = 2; i <= N; i++) {
            if (i == 2) {
                D[i][ZERO] = D[i - 1][ONE];
            } else {
                D[i][ONE] = D[i - 1][ZERO];
                D[i][ZERO] = D[i - 1][ZERO] + D[i - 1][ONE];
            }
        }
        bw.write(String.valueOf(D[N][ONE] + D[N][ZERO]));
        bw.flush();
        br.close();
        bw.close();
    }
}