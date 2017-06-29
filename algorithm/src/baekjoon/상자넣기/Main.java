package baekjoon.상자넣기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 상자 넣기 (문제번호 : 1965)
 * 
 * @category Dynamic Programming (LIS)
 * @since 2016.11.17
 * @author dongha
 */
public class Main {
	static int[] box;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		box = new int[N];

		for (int i = 0; i < N; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		int Answer = LIS();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(Answer));
		bw.flush();
		bw.close();
	}

	private static int LIS() {
		int CNT = 0;
		int[] D = new int[N];
		D[CNT] = box[0];

		for (int i = 1; i < N; ++i) {
			int next = box[i];
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

	private static int binary(int val, int[] D, int R) {
		int r = R;
		int l = 0;
		int m = 0;
		while (l <= r) {
			m = (l + r + 1) / 2;
			if (D[m] < val) {
				l = m + 1;
			} else {
				r = m - 1;
			}
			int nm = (l + r + 1) / 2;
			if (D[nm] > D[m]) {
				m = nm;
				break;
			}
		}
		return m;
	}
}