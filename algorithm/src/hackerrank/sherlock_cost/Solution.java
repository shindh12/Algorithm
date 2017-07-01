package hackerrank.sherlock_cost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Sherlock and Cost
 * 
 * @category Dynamic Programming
 * @since 2017.07.01
 * @author dongha
 */
public class Solution {
	static final int INF = 987654321;
	static int[] A;
	static int[] B; 
	static int[][] D;
	
	static final int Bi = 0;
	static final int ONE = 1;
	
	
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			B = new int[N+1];
			A = new int[N];
			D = new int[N+1][2];
			for (int i = 1; i <= N; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			// Ai를 고를 때 Bi를 고르냐 1을 고르냐 둘 중 하나
//			int Answer = Math.max(dp(1,Bi), dp(1,ONE));
			int Answer = dp2();
			bw.write(String.valueOf(Answer + "\n"));
			bw.flush();
		}
		br.close();
		bw.close();
	}
	private static int dp2(){
		//D[i][Bi] = Ai 를 Bi로 선택했을 경우의 최대 S 값
		//D[i][ONE] = Ai 를 1로 선택했을 경우의 최대 S 값
		
		//초기 D[1][Bi] = i는 2부터이므로 0으로 초기화
		//D[1][Bi] = D[1][ONE] = 0;
		

		// 1. i번째 Bi를 선택할 경우 (D[i][Bi])
		// max(B[i] - B[i-1) 일 경우, B[i] - 1) 일 경우)
		// 2. i번째 1을 선택한 경우 (D[i][ONE])
		// max(1 - B[i-1) 일 경우, 1 - 1 일 경우)
		
		for(int i=2;i<=N;i++){
			D[i][Bi] = Math.max(D[i-1][Bi] + Math.abs(B[i] - B[i-1]), D[i-1][ONE] + Math.abs(B[i] - 1));
			D[i][ONE] = Math.max(D[i-1][Bi] + Math.abs(1 - B[i-1]), D[i-1][ONE]);
		}
		
		return Math.max(D[N][Bi], D[N][ONE]);
	}
	private static int dp(int i, int b) {
		if(i==N) return 0;
		if(D[i][b]!=0) return D[i][b];
		
		int before = b==Bi ? B[i] : 1;
		
		int case1 = dp(i+1, Bi) + Math.abs(before - B[i+1]);
		int case2 = dp(i+1, ONE) + Math.abs(before - 1);
		
		return D[i][b] = Math.max(case1, case2);
	}
}
