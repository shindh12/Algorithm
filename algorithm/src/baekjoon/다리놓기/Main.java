package baekjoon.다리놓기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 다리 놓기 (문제번호 : 1010)
 * 
 * @category Dynamic Programming
 * @since 2017.06.18
 * @author dongha
 */

public class Main {
	static final int MAX = 29;
	static int T;
	static int[][] D;
	//비용의 범위 조건에 따라 int나 long
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());

		// n (0<n<=m<30) 의 값에 따라 가지 수가 항상 같이 때문에
		// 문제를 다 해결 한 후 입력만 받아 D[m][n]으로 출력하는 것이 최적화

		
		// 다리를 건너려면 동쪽에서 N개를 뽑아 서쪽의 다리를 순서대로 놓아주면 됨
		// M개의 사이트 중 N개를 뽑는 경우이므로 조합 문제
		D = new int[MAX+1][MAX+1];
		 // 부분문제 해결
		for(int i=0;i<=MAX;i++){
			D[i][0] = 1;
			D[i][i] = 1;
		}
		 //부분문제 이용하여 큰 문제 해결
		for(int i=1;i<=MAX;i++){
			for(int j=1;j<MAX;j++){
				D[i][j] = D[i-1][j-1] + D[i-1][j];
			}
		}

		for(int test_case=1;test_case<=T;test_case++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			bw.write(String.format("%d\n", D[m][n]));
			bw.flush();
		}
		bw.close();
		br.close();
	}
}