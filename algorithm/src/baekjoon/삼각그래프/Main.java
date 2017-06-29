package baekjoon.삼각그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 삼각 그래프 (문제번호 : 4883)
 * 
 * @category Dynamic Programming
 * @since 2017.06.15
 * @author dongha
 */
public class Main {
	static int N;
	static int[][] A;
	static long[][] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			A = new int[N][3];
			D = new long[N][3];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				A[i][0] = Integer.parseInt(st.nextToken());
				A[i][1] = Integer.parseInt(st.nextToken());
				A[i][2] = Integer.parseInt(st.nextToken());
			}

			D[0][2] = A[0][1] + A[0][2];
			D[1][0] = A[1][0] + A[0][1];
			D[1][1] = A[1][1] + Math.min(D[0][2], Math.min(D[1][0], A[0][1]));
			D[1][2] = A[1][2] + Math.min(Math.min(D[0][2], D[1][1]), A[0][1]);

			for (int i = 2; i < N; i++) {
				D[i][0] = A[i][0] + Math.min(D[i - 1][0], D[i - 1][1]);
				D[i][1] = A[i][1] + Math.min(Math.min(D[i - 1][0], D[i][0]), Math.min(D[i - 1][1], D[i - 1][2]));
				D[i][2] = A[i][2] + Math.min(D[i - 1][1], Math.min(D[i - 1][2], D[i][1]));
			}
			bw.write(String.format("%d. %d\n", k++, D[N - 1][1]));
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
