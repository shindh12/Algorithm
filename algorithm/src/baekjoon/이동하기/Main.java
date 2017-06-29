package baekjoon.이동하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 이동하기(문제번호 : 11048)
 * 
 * @category Dynamic Programming
 * @since 2016.11.16
 * @author dongha
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] maze = new int[N][M];
		int[][] D = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		D[0][0] = maze[0][0];
		// 0열의 부분 문제 해결
		for (int i = 1; i < N; i++) {
			D[i][0] = D[i - 1][0] + maze[i][0];
		}
		// 0행의 부분 문제 해결
		for (int i = 1; i < M; i++) {
			D[0][i] = D[0][i - 1] + maze[0][i];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				D[i][j] = Math.max(D[i - 1][j - 1], Math.max(D[i][j - 1], D[i - 1][j])) + maze[i][j];
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(D[N - 1][M - 1]));
		bw.flush();
		bw.close();
	}
}