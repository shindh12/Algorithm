package baekjoon.동전1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 동전1 (문제번호 : 2293)
 * 
 * @category Dynamic Programming
 * @since 2016.11.16
 * @author dongha
 */

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] C = new int[n];
		int[] D = new int[k + 1];

		for (int i = 0; i < n; i++) {
			C[i] = Integer.parseInt(br.readLine());

		}
		br.close();
		D[0] = 1;
		for (int j = 0; j < n; j++) {
			for (int i = 1; i <= k; i++) {
				int prev = i - C[j];
				if (prev >= 0) {
					D[i] += D[prev];
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(D[k]));
		bw.flush();
		bw.close();
	}
}