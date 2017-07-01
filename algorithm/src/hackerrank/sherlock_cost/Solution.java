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
			
			// Ai�� �� �� Bi�� ���� 1�� ���� �� �� �ϳ�
//			int Answer = Math.max(dp(1,Bi), dp(1,ONE));
			int Answer = dp2();
			bw.write(String.valueOf(Answer + "\n"));
			bw.flush();
		}
		br.close();
		bw.close();
	}
	private static int dp2(){
		//D[i][Bi] = Ai �� Bi�� �������� ����� �ִ� S ��
		//D[i][ONE] = Ai �� 1�� �������� ����� �ִ� S ��
		
		//�ʱ� D[1][Bi] = i�� 2�����̹Ƿ� 0���� �ʱ�ȭ
		//D[1][Bi] = D[1][ONE] = 0;
		

		// 1. i��° Bi�� ������ ��� (D[i][Bi])
		// max(B[i] - B[i-1) �� ���, B[i] - 1) �� ���)
		// 2. i��° 1�� ������ ��� (D[i][ONE])
		// max(1 - B[i-1) �� ���, 1 - 1 �� ���)
		
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
