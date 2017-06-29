package baekjoon.동물원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 동물원 (문제번호 : 1309)
 * 
 * @category Dynamic Programming
 * @since 2017.06.14
 * @author dongha
 */
public class Main {
	static final int MOD = 9901;
	static final int LEFT = 0; // 사자 왼쪽 둘때
	static final int RIGHT = 1; // 사자 오른쪽 안둘때
	static final int OFF = 2; // 안둘때
	static int[][] D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
	
		D = new int[N][3];  // D[i][0] = i번째 왼쪽 칸에만 두는 경우
		D[0][LEFT] = 1;
		D[0][RIGHT] = 1;
		D[0][OFF] = 1;
		
        // 왼쪽에 두려면 이전에는 오른쪽에 두었거나 둘 다 안두었거나
        // 오른쪽에 두려면 이전에 왼쪽에 두었거나 둘 다 안두었거나
        // 둘 다 안두면 이전의 모든 경우 가능
		for(int i=1;i<N;i++){
			D[i][LEFT] = (D[i-1][RIGHT] + D[i-1][OFF]) % MOD; 
			D[i][RIGHT] = (D[i-1][LEFT] + D[i-1][OFF]) % MOD;
			D[i][OFF] = (D[i-1][LEFT] + D[i-1][RIGHT] + D[i-1][OFF]) % MOD;
		}
		int Answer = (D[N-1][LEFT]+D[N-1][RIGHT]+D[N-1][OFF]) % MOD;
		bw.write(String.format("%d", Answer));
		bw.flush();
		br.close();
		bw.close();
	}
}

