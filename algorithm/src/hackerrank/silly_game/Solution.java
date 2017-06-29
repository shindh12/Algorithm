package hackerrank.silly_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Alice and Bob's Silly Game
 * 
 * @category Game Theory
 * @since 2017.06.29
 * @author dongha
 */
public class Solution {
	static final String ALICE = "Alice";
	static final String BOB = "Bob";
	
	static final int MAX_N = 100000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] D = new int[MAX_N+1];
		init(D); // 답이 언제나 같으므로 미리 답을 구하고 시작
		
		int G = Integer.parseInt(br.readLine());
		for(int g=0;g<G;g++){
			int N = Integer.parseInt(br.readLine());
			
			// BOB이 이기는 경우는 소수를 짝수개 나왔을때 ALICE는 반대
			String Answer = D[N]%2==0 ? BOB : ALICE;
			bw.write(String.valueOf(Answer + "\n"));
			bw.flush();
		}
		br.close();
		bw.close();
	}

	private static void init(int[] D) {
		D[1] = 0;
		D[2] = 1;
		int cnt = 1;
		for(int i=3;i<=MAX_N;i++){
			if(isPrime(i)) cnt++;
			D[i] = cnt;
		}
	}
	
	// i가 소수인지는 Sqrt(i) 개만 보면 된다. 
	// i가 16일때  1 2 4 8 16 으로 봤을때, sqrt(16)인 4까지만 본다
	// 4를 기준으로 오른쪽은 왼쪽에 있는 수의 곱해지는 짝이기 때문에 보지 않아도 소수 판별 가능
	private static boolean isPrime(int i) {
		for(int j=2;j<=Math.sqrt(i);j++){
			if(i%j==0) return false;
		}
		return true;
	}
}