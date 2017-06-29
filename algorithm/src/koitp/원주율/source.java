package koitp.원주율;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 원주율
 * 
 * @category 수학이론 (몬테 칼로 알고리즘 - 원주율 구하기)
 * @since 2016.11.04
 * @author dongha
 */

public class source {
    static final int N = 500000;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        br.close();
         
         
        double PI = 0;
        PI = getProbability(N);
 
        bw.write(String.format("%.2f", PI));
        bw.flush();
        bw.close();
    }
 
    /**
     * 길이가 1인 사각형 내부에 사분원이 있다고 가정
     */
    static double getProbability(int tot) {
        int cntInCircle = 0; // 사분원 안에 찍히는 점의 갯수 
        for (int i = 0; i < tot; i++) { // 
            double x = Math.random();
            double y = Math.random();
 
            if (x * x + y * y <= 1) { // 사분원에 있는 점이면 카운트
                cntInCircle++;
            }
        }
        return (double) cntInCircle / tot * 4; // 사분원이니깐 곱하기 4
    }
}