package baekjoon.ºØ¾î»§ÆÇ¸ÅÇÏ±â;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * ºØ¾î»§ ÆÇ¸ÅÇÏ±â (¹®Á¦¹øÈ£ : 11052)
 * 
 * @category Dynamic Programming
 * @since 2016.11.16
 * @author dongha
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] F = new int[N + 1];
		int[] D = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			F[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		D[1] = F[1];

		for (int i = 2; i <= N; i++) {
			for (int k = 1; k <= i; k++) {
				D[i] = Math.max(D[i], D[i - k] + F[k]);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(D[N]));
		bw.flush();
		bw.close();
	}
}
