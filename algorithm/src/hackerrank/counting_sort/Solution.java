package hackerrank.counting_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Counting Sort 2
 * 
 * @category Sort
 * @since 2017.06.27
 * @author dongha
 */

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] ar = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//���ڸ� index�� ��� �ش��ϴ� �迭���� ���������ش�.
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			ar[idx]++;
		} 

		for(int i=0;i<N;i++){
			int cnt = ar[i];
			for(int x=0;x<cnt;x++){
				bw.write(String.format("%d ", i));
			} // �ش� ���� ������� ������ŭ ���
		}
		bw.flush();
		br.close();
		bw.close();
	}
}