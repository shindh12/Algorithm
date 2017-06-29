package baekjoon.연속합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 연속합 (문제번호 : 1912)
 * 
 * @category Dynamic Programming
 * @since 2017.06.04
 * @author dongha
 */
public class Main {
	static final int MIN = -987654321;
	static int N;
	static int[] A;
	static int[] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		D = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// int Answer = dp();
		int Answer = dp2();

		bw.write(String.format("%d", Answer));
		bw.flush();
		br.close();
		bw.close();
	}

	static int dp(int i) {
		if (i == N)
			return 0; // 기저 끗
		if(D[i]!=0) return D[i];
		int Answer = MIN;
		int left = dp(i + 1) + A[i + 1];
		int right = A[i + 1];
		return D[i] = left + right;
	}

	static int dp2() {
		D[0] = A[0];
		int Answer = D[0];
		for (int i = 1; i < N; i++) {
			D[i] = Math.max(D[i - 1] + A[i], A[i]);
			Answer = Math.max(Answer, D[i]);
		}
		return Answer;
	}

	static int brute_force() {
		int Answer = MIN;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = i; j < N; j++) {
				sum += A[j];
				Answer = Math.max(sum, Answer);
			}
		}
		return Answer;
	}
}
