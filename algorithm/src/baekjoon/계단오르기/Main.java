package baekjoon.계단오르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 계단 오르기 (문제번호 : 2579)
 * 
 * @category Dynamic Programming
 * @since 2016.11.16
 * @author dongha
 */
public class Main {
	static final int ONE_STEP = 0;
	static final int TWO_STEP = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] step = new int[N + 1];
		int[][] D = new int[N + 1][2];
		// D[i][ONE_STEP] = i번째 계단일때 한 계단으로 온 경우
		// D[i][TWO_STEP] = i번째 계단일때 두 계단으로 온 경우

		for (int i = 1; i <= N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		D[1][ONE_STEP] = step[1];
		D[1][TWO_STEP] = step[1];

		for (int i = 2; i <= N; i++) {
			D[i][ONE_STEP] = D[i - 1][TWO_STEP] + step[i];
			D[i][TWO_STEP] = Math.max(D[i - 2][TWO_STEP], D[i - 2][ONE_STEP]) + step[i];
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(Math.max(D[N][ONE_STEP], D[N][TWO_STEP])));
		bw.flush();
		bw.close();
	}
}
