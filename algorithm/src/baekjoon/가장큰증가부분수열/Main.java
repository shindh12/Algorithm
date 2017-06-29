package baekjoon.가장큰증가부분수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 가장 큰 증가 부분 수열 (문제번호 : 11055)
 * 
 * @category Dynamic Programming (LIS)
 * @since 2016.11.17
 * @author dongha
 */
public class Main {
	static int[] sum;
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];
		sum = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		int Answer = LIS();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(Answer));
		bw.flush();
		bw.close();
	}

	private static int LIS() {
		int[] D = new int[N];

		D[N - 1] = arr[N - 1];

		for (int i = N - 2; i >= 0; --i) {
			int max = 0;
			for (int j = i + 1; j < N; j++) {
				if (arr[i] < arr[j]) {
					max = Math.max(D[j], max);
				}
			}
			D[i] = arr[i] + max;
		}
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, D[i]);
		}
		return max;
	}

}