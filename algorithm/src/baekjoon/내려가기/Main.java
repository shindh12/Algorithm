package baekjoon.내려가기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 내려가기 (문제번호 : 2096)
 * 
 * @category Dynamic Programming
 * @since 2017.06.22
 * @author dongha
 */

public class Main {
	static final int MAX = 987654321;
	static int N;
	static int[][] A;
	static int[][] D; // max dp
	static int[][] E; // min dp

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		A = new int[N][3];
		D = new int[N][3];
		E = new int[N][3];
		
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++){
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		int max_Answer = max(dp(0, 0), dp(0, 1), dp(0, 2));
//		int min_Answer = min(dp2(0, 0), dp2(0, 1), dp2(0, 2));
		
		dp3();
		int max_Answer = max(D[N-1][0], D[N-1][1], D[N-1][2]);
		int min_Answer = min(E[N-1][0], E[N-1][1], E[N-1][2]);
		bw.write(String.format("%d %d", max_Answer, min_Answer));
		bw.flush();
		bw.close();
		br.close();
	}
	// 상향식.. 반복문
	static void dp3(){
		for(int i=0;i<3;i++){
			D[0][i] = A[0][i];
			E[0][i] = A[0][i];
		}
		
		for(int i=1;i<N;i++){
			D[i][0] = A[i][0] + max(D[i-1][0], D[i-1][1]);
			D[i][1] = A[i][1] + max(D[i-1][0], D[i-1][1], D[i-1][2]);
			D[i][2] = A[i][2] + max(D[i-1][1], D[i-1][2]);
			
			E[i][0] = A[i][0] + min(E[i-1][0], E[i-1][1]);
			E[i][1] = A[i][1] + min(E[i-1][0], E[i-1][1], E[i-1][2]);
			E[i][2] = A[i][2] + min(E[i-1][1], E[i-1][2]);
		}
	}
	//max 값 찾기 (하향식)
	static int dp(int r, int c){
		if(r==N-1) return A[r][c];
		
		if(D[r][c]!=0) return D[r][c];
		int col1 = 0; 
		int col2 = 0;
		int col3 = 0;
		if(c==0) col1 = max(dp(r+1, c), dp(r+1, c+1));
		else if(c==1) col2 = max(dp(r+1, c-1), dp(r+1, c), dp(r+1, c+1));
		else col3 = max(dp(r+1, c-1), dp(r+1, c));
		
		return D[r][c] = A[r][c] + max(col1, col2, col3);
	}
	//min 값 찾기 (하향식)
	static int dp2(int r, int c){
		if(r==N-1) return A[r][c];
		
		if(E[r][c]!=0) return E[r][c];

		int col1 = MAX; 
		int col2 = MAX;
		int col3 = MAX;
		if(c==0) col1 = min(dp2(r+1, c), dp2(r+1, c+1));
		else if(c==1) col2 = min(dp2(r+1, c-1), dp2(r+1, c), dp2(r+1, c+1));
		else col3 = min(dp2(r+1, c-1), dp2(r+1, c));
		
		return E[r][c] = A[r][c] + min(col1, col2, col3);
	}
	
	static int max(int a, int b){
		return (a >= b) ? a : b;
	}
	static int max(int a, int b, int c){
		return max(a, max(b, c));
	}
	static int min(int a, int b){
		return (a <= b) ? a : b;
	}
	static int min(int a, int b, int c){
		return min(a, min(b, c));
	}
}