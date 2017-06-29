package baekjoon.소형기관차;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 소형 기관차 (문제번호 : 2616)
 * 
 * @category Dynamic Programming
 * @since 2016.12.04
 * @author dongha
 */
public class Main {
	static final int FIRST = 0;
	static final int SECOND = 1;
	static final int THIRD = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 1];
		int[] dSum = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			T[i] = Integer.parseInt(st.nextToken());
			dSum[i] = dSum[i - 1] + T[i];
		}

		int M = Integer.parseInt(br.readLine());
		int[][] D = new int[3][N + 1];

		for (int i = M; i <= N - (M * 2); i++) {
			D[0][i] = Math.max(D[0][i - 1], dSum[i] - dSum[i - M]);
		}
		for (int i = 1; i < 3; i++) {
			for (int j = M * i + M; j <= N - (M * (2 - i)); j++) {
				D[i][j] = Math.max(D[i - 1][j - M] + dSum[j] - dSum[j - M], D[i][j - 1]);
			}
		}
		bw.write(String.valueOf(D[2][N]));
		bw.flush();
		br.close();
		bw.close();
	}
}