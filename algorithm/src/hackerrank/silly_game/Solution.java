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
		init(D); // ���� ������ �����Ƿ� �̸� ���� ���ϰ� ����
		
		int G = Integer.parseInt(br.readLine());
		for(int g=0;g<G;g++){
			int N = Integer.parseInt(br.readLine());
			
			// BOB�� �̱�� ���� �Ҽ��� ¦���� �������� ALICE�� �ݴ�
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
	
	// i�� �Ҽ������� Sqrt(i) ���� ���� �ȴ�. 
	// i�� 16�϶�  1 2 4 8 16 ���� ������, sqrt(16)�� 4������ ����
	// 4�� �������� �������� ���ʿ� �ִ� ���� �������� ¦�̱� ������ ���� �ʾƵ� �Ҽ� �Ǻ� ����
	private static boolean isPrime(int i) {
		for(int j=2;j<=Math.sqrt(i);j++){
			if(i%j==0) return false;
		}
		return true;
	}
}