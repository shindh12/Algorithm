package baekjoon.������;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * ������ (������ȣ : 1309)
 * 
 * @category Dynamic Programming
 * @since 2017.06.14
 * @author dongha
 */
public class Main {
	static final int MOD = 9901;
	static final int LEFT = 0; // ���� ���� �Ѷ�
	static final int RIGHT = 1; // ���� ������ �ȵѶ�
	static final int OFF = 2; // �ȵѶ�
	static int[][] D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
	
		D = new int[N][3];  // D[i][0] = i��° ���� ĭ���� �δ� ���
		D[0][LEFT] = 1;
		D[0][RIGHT] = 1;
		D[0][OFF] = 1;
		
        // ���ʿ� �η��� �������� �����ʿ� �ξ��ų� �� �� �ȵξ��ų�
        // �����ʿ� �η��� ������ ���ʿ� �ξ��ų� �� �� �ȵξ��ų�
        // �� �� �ȵθ� ������ ��� ��� ����
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

