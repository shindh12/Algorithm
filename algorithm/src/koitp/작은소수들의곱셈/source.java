package koitp.작은소수들의곱셈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * 작은 소수들의 곱셈
 * 
 * @category Data Structure (우선순위 큐)
 * @since 2016.12.04
 * @author dongha
 */

public class source {
 
    static final int N = 5842;
 
    static final int[] prime = { 2, 3, 5, 7 };
 
    static long[] R;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        R = new long[N];
        init();
 
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine()) - 1;
            bw.write(String.valueOf(R[n])+"\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
 
    /**
     * 결과값 전처리
     */
    private static void init() {
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        int length = prime.length;
        int cnt = 0;
        q.add(1l); // 최초 1부터 시작
        while (!q.isEmpty()) {
            if (cnt > N - 1) // 5842개 까지만
                break;
            long current = q.remove(); // 오름차순대로 값 저장
            R[cnt] = current; 
            cnt++;
            for (int i = 0; i < length; i++) {
                long next = current * prime[i]; // 나온 순서대로 2, 3, 5, 7을 곱함
                if (q.contains(next)) continue; // 이미 있는 숫자면 추가시키지 않음
                q.add(next);
            }
        }
    }
}