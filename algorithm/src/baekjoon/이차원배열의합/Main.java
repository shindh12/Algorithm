package baekjoon.이차원배열의합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 2차원 배열의 합(문제번호 : 2167)
 * 
 * @category Dynamic Programming
 * @since 2017.06.10
 * @author dongha
 */

public class Main {
	static int N;
	static int M;
	static int K;

	static int[][] A;
	static int[][] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N + 1][M + 1];
		D = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				D[i][j] = D[i][j - 1] + A[i][j];
			}
		}
		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int x = x2 - x1 + 1; // 행 갯수
			int y = y2 - y1 + 1; // 열 갯수

			int Answer = 0;

			for (int j = 0; j < x; j++) {
				Answer += (D[x2 - j][y2] - D[x2 - j][y2 - y]);
			}

			bw.write(String.format("%d\n", Answer));
			bw.flush();
		}
		br.close();
		bw.close();
	}

}
