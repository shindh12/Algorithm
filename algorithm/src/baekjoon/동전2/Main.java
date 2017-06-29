package baekjoon.동전2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 동전2 (문제번호 : 2294)
 * 
 * @category Dynamic Programming
 * @since 2016.11.16
 * @author dongha
 */

public class Main {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] C = new int[n];
		int[] D = new int[k+1];
		
		for(int i =0;i<n;i++){
			C[i] = Integer.parseInt(br.readLine());
			if(C[i] <= 10000) D[C[i]] = 1;
		}
		br.close();
		
		for(int money=1;money<=k;money++){
			for(int i=0;i<n;i++){
				if(D[money]==0) D[money] = INF;
				int current = money - C[i];
				if(current >= 0) D[money] = Math.min(D[money], D[current] + 1);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(D[k]==INF ? "-1" : String.valueOf(D[k]));
		bw.flush();
		bw.close();
	}
}