package baekjoon.�ٸ�����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * �ٸ� ���� (������ȣ : 1010)
 * 
 * @category Dynamic Programming
 * @since 2017.06.18
 * @author dongha
 */

public class Main {
	static final int MAX = 29;
	static int T;
	static int[][] D;
	//����� ���� ���ǿ� ���� int�� long
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());

		// n (0<n<=m<30) �� ���� ���� ���� ���� �׻� ���� ������
		// ������ �� �ذ� �� �� �Է¸� �޾� D[m][n]���� ����ϴ� ���� ����ȭ

		
		// �ٸ��� �ǳʷ��� ���ʿ��� N���� �̾� ������ �ٸ��� ������� �����ָ� ��
		// M���� ����Ʈ �� N���� �̴� ����̹Ƿ� ���� ����
		D = new int[MAX+1][MAX+1];
		 // �κй��� �ذ�
		for(int i=0;i<=MAX;i++){
			D[i][0] = 1;
			D[i][i] = 1;
		}
		 //�κй��� �̿��Ͽ� ū ���� �ذ�
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