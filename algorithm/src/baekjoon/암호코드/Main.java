package baekjoon.암호코드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 암호 코드 (문제번호 : 2011)
 * 
 * @category Dynamic Programming
 * @since 2017.06.13
 * @author dongha
 */
public class Main {
	static final int MOD = 1000000;
	static int[] D = new int[5001]; // 5000자리 수
	static int E;
	static String pw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		pw = br.readLine();

		E = pw.length();
		// int Answer = dp(0);
		int Answer = dp2() % MOD;
		// System.out.println(pw.substring(4, 6));
		bw.write(String.format("%d", Answer));
		bw.flush();
		br.close();
		bw.close();
	}

	static int dp2() {
		D[0] = 1;

		for (int i = 1; i <= E; i++) {
			int num1 = Integer.parseInt(pw.substring(i - 1, i));
			if (num1 >= 1 && num1 <= 9)
				D[i] = (D[i - 1] + D[i]) % MOD;
			if (i == 1)
				continue;

			int num2 = Integer.parseInt(pw.substring(i - 2, i));
			if (num2 <= 26 && num2 >= 10)
				D[i] = (D[i - 2] + D[i]) % MOD;
		}
		return D[E];
	}

}
