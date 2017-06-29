package baekjoon.포도주시식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 상자 넣기 (문제번호 : 2156)
 * 
 * @category Dynamic Programming
 * @since 2016.11.17
 * @author dongha
 */
public class Main {

	static final int ONE = 0; // 첫번째 전 마셨을때
	static final int TWO = 1; // 두번째 전 마셨을때
	static final int NO = 2; // 안마셨을때

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] wine = new int[N];
		int[][] D = new int[N][3];
		// D[i][ONE] = i번째 와인을 첫번째로 마신 경우
		// D[i][TWO] = i번째 와인을 두개 연속째 마신 경우
		// D[i][NO] = i번째 와인 안마신 경우
		for (int i = 0; i < N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		D[0][ONE] = wine[0]; // 초기 부분문제를 풀어놓는다
		// D[0][NO] = 0; D[0][TWO] = 0;

		for (int i = 1; i < N; i++) {
			D[i][ONE] = wine[i] + D[i - 1][NO];
			D[i][TWO] = wine[i] + D[i - 1][ONE];
			D[i][NO] = Math.max(D[i - 1][NO], Math.max(D[i - 1][ONE], D[i - 1][TWO]));
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(Math.max(D[N - 1][TWO], Math.max(D[N - 1][ONE], D[N - 1][NO]))));
		bw.flush();
		bw.close();
	}

}