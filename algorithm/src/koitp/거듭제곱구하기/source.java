package koitp.°ÅµìÁ¦°ö±¸ÇÏ±â;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * °Åµì Á¦°ö ±¸ÇÏ±â
 * 
 * @category ±¸Çö (ºñÆ®)
 * @since 2016.11.25
 * @author dongha
 */

public class source {
    static final int MOD = 1000000007;
    static final int LONG_BIT = 64;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
 
        long Answer = 1;
        long[] B = new long[LONG_BIT];
 
        B[0] = 1;
        for (int i = 1; i < LONG_BIT; i++) {
            B[i] = B[i - 1] * 2;
        }
        for (int i = 0; i < LONG_BIT; i++) {
            if ((m & (1l << i)) == 0) {
                continue;
            }
            Answer = (Answer * mul(a, B[i])) % MOD;
 
        }
 
        bw.write(String.valueOf(Answer));
 
        bw.flush();
        br.close();
        bw.close();
    }
 
    static long mul(long a, long m) {
        if (m == 1)
            return a;
        long ret = mul(a, m / 2) % MOD;
        ret = (ret * ret) % MOD;
        return ret;
    }
}