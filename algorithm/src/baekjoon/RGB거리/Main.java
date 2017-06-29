package baekjoon.RGB거리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * RGB 거리 (문제번호 : 1149)
 * 
 * @category Dynamic Programming
 * @since 2017.06.16
 * @author dongha
 */


public class Main {
	static final int MAX = 987654321;
	static final int R = 0;
	static final int G = 1;
	static final int B = 2;
	
	static int N;
	static int[][] H; //house
	static int[][] D;
	//비용의 범위 조건에 따라 int나 long
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter	(System.out));
		N = Integer.parseInt(br.readLine());
		
		H = new int[N][3];
		D = new int[N][3];
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			H[i][R] = Integer.parseInt(st.nextToken());
			H[i][G] = Integer.parseInt(st.nextToken());
			H[i][B] = Integer.parseInt(st.nextToken());
		}
		
//		int Answer = min(dp(0, R), dp(0, G), dp(0, B));
		int Answer = dp2();
		
		bw.write(String.format("%d", Answer));
		bw.flush();
		bw.close();
		br.close();
		
	}
	static int dp(int i, int color) {
		if(i==N) return 0;
		
		if(D[i][color]!=0) return D[i][color];
		int red = MAX;
		int green = MAX;
		int blue = MAX;
		
		if(color!=R) red = dp(i+1, R) + H[i][color];
		if(color!=G) green = dp(i+1, G) + H[i][color];
		if(color!=B) blue = dp(i+1, B) + H[i][color];
		
		return D[i][color] = min(red, green, blue);
	}
	static int dp2(){
		D[0][R] = H[0][R];
		D[0][G] = H[0][G];
		D[0][B] = H[0][B];

		for(int i=1;i<N;i++){
			D[i][R] = H[i][R] + min(D[i-1][G], D[i-1][B]);
			D[i][G] = H[i][G] + min(D[i-1][R], D[i-1][B]);
			D[i][B] = H[i][B] + min(D[i-1][R], D[i-1][G]);
		}
		
		return min(D[N-1][R], D[N-1][G], D[N-1][B]);
	}
	static int min(int a, int b){
		return Math.min(a,  b);
	}
	static int min(int a, int b, int c){
		return Math.min(a, Math.min(b, c));
	}
}

