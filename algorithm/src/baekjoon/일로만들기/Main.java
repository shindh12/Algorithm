package baekjoon.일로만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1로 만들기 (문제번호 : 1463)
 * 
 * @category Dynamic Programming
 * @since 2017.06.15
 * @author dongha
 */
public class Main {
	static final int MAX = 987654321;
	static int[] D;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		D = new int[N + 1];
		// int Answer = dp(N);
		int Answer = dp2();

		bw.write(String.format("%d", Answer));
		bw.flush();
		bw.close();
		br.close();
	}

	static int dp(int n) {
		if (n == 1) {
			return 0;
		}
		if (D[n] != 0)
			return D[n];

		int case1 = MAX;
		int case2 = MAX;
		int case3 = MAX;

		if (n % 3 == 0)
			case1 = dp(n / 3) + 1;
		if (n % 2 == 0)
			case2 = dp(n / 2) + 1;

		case3 = dp(n - 1) + 1;

		return D[n] = min(case1, case2, case3);

	}

	static int dp2() {
		D[N] = 1;

		for (int i = N; i >= 1; i--) {
			if (D[i] == 0)
				continue;
			int now = 0;

			if (i % 3 == 0) {
				now = i / 3;
				D[now] = min(D[now] == 0 ? MAX : D[now], D[i] + 1);
			}
			if (i % 2 == 0) {
				now = i / 2;
				D[now] = min(D[now] == 0 ? MAX : D[now], D[i] + 1);
			}
			now = i - 1;
			D[now] = min(D[now] == 0 ? MAX : D[now], D[i] + 1);
		}

		return D[1] - 1;
	}

	static int min(int a, int b) {
		return Math.min(a, b);
	}

	static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
}