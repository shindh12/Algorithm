package baekjoon.이친수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 이친수 (문제번호 : 2193)
 * 
 * @category Dynamic Programming
 * @since 2017.06.16
 * @author dongha
 */

public class Main {
	static int N;
	static long[][] D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		D = new long[N+1][2];
		
		long Answer = dp(1, 1); 
//		long Answer = dp2();

		bw.write(String.format("%d", Answer));
		bw.flush();
		bw.close();
		br.close();
	}
	static long dp2() {
		D[1][1] = 1;
		for(int i=2;i<=N;i++){
			if(i==2) { D[i][0] = D[i-1][1]; continue;}
			D[i][0] = D[i-1][1] + D[i-1][0];
			D[i][1] = D[i-1][0];
		}
		return D[N][0] + D[N][1];
	}
	
	static long dp(int i, int now) {
		if(i==N) return 1;
		
		if(D[i][now]!=0) return D[i][now];
		
		long case1 = dp(i+1, 0);
		long case2 = 0;
		if(now==0) case2 = dp(i+1, 1);
		
		return D[i][now] = case1 + case2;
	}
}
