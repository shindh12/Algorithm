package hackerrank.equal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Equal
 * 
 * @category Dynamic Programming
 * @since 2017.06.29
 * @author dongha
 */
public class Solution {
	static final int INF = 987654321;
	static final int[] type = { 5, 2, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("equal_input.txt")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] D = new int[1005][1005];
		init(D);
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int E = INF;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				E = Math.min(A[i], E);
			}

			// 한명을 제외한 나머지를 올리는게 아니라
			// 나머지를 제외한 한명을 줄여서 최솟값에 맞춘다
			int Answer = INF;
			for (int e = 0; e <= E; e++) {
				for (int k = 0; k <= 2; k++) {
					int cand = 0;
					for (int i = 0; i < N; i++) {
						cand += D[A[i]+k][e];
					}
					Answer = Math.min(cand, Answer);
				}
			}

			bw.write(String.valueOf(Answer + "\n"));
			bw.flush();
		}
		br.close();
		bw.close();
	}

	// 초기 초콜렛 개수 C라고 할때 O(C^2)
	private static void init(int[][] D) {
		for (int i = 1; i < 1005; i++) {
			for (int j = 0; j < i; j++) {
				// i -> j 로 가는 갯수 D[3][2] 일 경우 3에서 2로 줄이는 갯수
				int diff = i - j;
				for (int k = 0; k < type.length; k++) {
					int cnt = 0;
					if (diff >= type[k]) {
						cnt = diff / type[k];
						diff -= cnt * type[k];
						D[i][j] += cnt;
					}
				}
			}
		}
	}
}
