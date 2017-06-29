package baekjoon.줄세우기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 줄 세우기 (문제번호 : 2631)
 * 
 * @category Dynamic Programming (LIS)
 * @since 2016.11.17
 * @author dongha
 */
public class Main {

	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		int Answer = N - LIS();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(Answer));
		bw.flush();
		bw.close();
	}

	private static int LIS() {
		int CNT = 0;
		int[] D = new int[N];
		D[CNT] = arr[0];

		for (int i = 1; i < N; ++i) {
			int next = arr[i];
			int current = D[CNT];
			if (current < next) {
				CNT++;
				D[CNT] = next;
			} else {
				int idx = find(next, D, CNT);
				D[idx] = next;
			}
		}
		return CNT + 1;
	}

	private static int find(int val, int[] D, int R) {
		for (int i = 0; i <= R; i++) {
			if (D[i] >= val)
				return i;
		}
		return 0;
	}
}