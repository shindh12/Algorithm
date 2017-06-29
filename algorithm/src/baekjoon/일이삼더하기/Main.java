package baekjoon.���̻���ϱ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1,2,3 ���ϱ� (������ȣ : 9095)
 * 
 * @category Dynamic Programming, DFS
 * @since 2017.06.17
 * @author dongha
 */
public class Main {
	static final int MAX = 11;
	static int T;
	static int[] D;
	//����� ���� ���ǿ� ���� int�� long
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter	(System.out));
		T = Integer.parseInt(br.readLine());

		// n (1<=n<=11) �� ���� ���� ���� ���� �׻� ���� ������
		// D�� �ʱ�ȭ ��Ų �� n�� �Է¸� �޾� D[n]���� ����ϴ� ���� ����ȭ

		D = new int[MAX+1];
		D[0] = 1;
		 // �κй��� �ذ�
		 //�κй��� �̿��Ͽ� ū ���� �ذ�
		for(int i=1;i<=MAX;i++){
			if(i-1 >= 0) 	D[i] += D[i-1];
			if(i-2 >= 0) D[i] += D[i-2];
			if(i-3 >= 0)	D[i] += D[i-3];
		}
		for(int test_case=1;test_case<=T;test_case++){
			int n = Integer.parseInt(br.readLine());
			bw.write(String.format("%d\n", D[n]));
			bw.flush();
		}
		

		
//		for(int test_case=1;test_case<=T;test_case++){
//			int n = Integer.parseInt(br.readLine());
//			D = new int[n+1];
//		int Answer = dp2(n);
//		int Answer = dp(n);
//		int Answer = dfs(n);
		
//			bw.write(String.format("%d\n", Answer));
//			bw.flush();
//		}
		bw.close();
		br.close();
		
	}
	
	// DP �����
	static int dp(int n) {
		if(n==0) return 1;
		if(D[n] != 0) return D[n];
		int case1 = 0;
		int case2 = 0;
		int case3 = 0;

		if(n-1 >= 0) 	case1 = dp(n-1);
		if(n-2 >= 0) case2 = dp(n-2);
		if(n-3 >= 0)	case3 = dp(n-3);
		
		return D[n] = case1 + case2 + case3;
	}
	// DP �����
	static int dp2(int n) {
		D[0] = 1;
		
		for(int i=1;i<=n;i++){
			if(i-1 >= 0) 	D[i] += D[i-1];
			if(i-2 >= 0) D[i] += D[i-2];
			if(i-3 >= 0)	D[i] += D[i-3];
		}
		
		return D[n];
	}

	// ������ �۾� dfs�� ����
	static int dfs(int n) {
		if(n==0) return 1;
		int case1 = 0;
		int case2 = 0;
		int case3 = 0;
		if(n-1 >= 0) 	case1 = dp(n-1);
		if(n-2 >= 0) case2 = dp(n-2);
		if(n-3 >= 0)	case3 = dp(n-3);
		
		return case1+case2+case3;
	}

}
