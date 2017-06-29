package baekjoon.점프점프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 점프 점프 (문제번호 : 11060)
 * 
 * @category Dynamic Programming
 * @since 2016.11.17
 * @author dongha
 */

public class Main {
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] D = new int[N];
		Arrays.fill(D, INF);
		br.close();
		D[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= A[i]; j++) {
				if (i + j < N)
					D[i + j] = Math.min(D[i + j], D[i] + 1);
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(D[N - 1] == INF ? -1 : D[N - 1]));
		bw.flush();
		bw.close();
	}
}