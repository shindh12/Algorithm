package baekjoon.숫자삼각형;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로 찾기 (문제번호 : 2178)
 * 
 * @category BFS
 * @since 2016.07.27
 * @author dongha
 */

public class Main {
	static int N;
	static int[][] triangle;
	static int[][] cache;

	// cache는 (1,1) ~ (y, x) 최대 누적량
	// 점화식 : cache[y][x] = Math.max(cache[y-1][x-1], cache[y-1][x]) +
	// triangle[x][y]
	// cache 초기값은 경계에 있는 애들로 채워 넣으면 됨
	// 1base로 하면 캐쉬를 일단 모두 -1 로 채워 넣었을 때,
	// 따로 초기화를 안해줘도 된다
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		triangle = new int[N][N];
		cache = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		// 초기화
		cache[0][0] = triangle[0][0];
		for (int i = 1; i < N; i++) {
			cache[i][0] = cache[i - 1][0] + triangle[i][0];
			cache[i][i] = cache[i - 1][i - 1] + triangle[i][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= i; j++) {
				cache[i][j] = Math.max(cache[i - 1][j - 1], cache[i - 1][j]) + triangle[i][j];
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(max,  cache[N-1][i]);
		}
		System.out.println(max);
	}

}
