package baekjoon.가장긴증가하는수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 수열 (문제번호 : 11053)
 * 
 * @category Dynamic Programming (LIS)
 * @since 2016.11.17
 * @author dongha
 */
public class Main {
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		int Answer = LIS();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		bw.write(String.valueOf(Answer));
		bw.flush();
		bw.close();
	}

	private static int LIS() {
		int CNT = 0;
		int[] D = new int[N];
		D[CNT] = arr[0];
		
		for (int i = 1; i < N; ++i) {
			int next = arr[i];
			int current = D[CNT];
			if(current < next){
				CNT++;
				D[CNT] = next;
			}else{
				int idx = find(next, D, CNT);
				D[idx] = next;
			}
			
		}
		return CNT+1;
	}
	private static int find(int val, int[] D, int R){
		for(int i=0;i<=R;i++){
			if(D[i] >= val) return i;
		}
		return 0;
	}
}