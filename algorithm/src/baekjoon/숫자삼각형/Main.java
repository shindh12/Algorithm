package baekjoon.���ڻﰢ��;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * �̷� ã�� (������ȣ : 2178)
 * 
 * @category BFS
 * @since 2016.07.27
 * @author dongha
 */

public class Main {
	static int N;
	static int[][] triangle;
	static int[][] cache;

	// cache�� (1,1) ~ (y, x) �ִ� ������
	// ��ȭ�� : cache[y][x] = Math.max(cache[y-1][x-1], cache[y-1][x]) +
	// triangle[x][y]
	// cache �ʱⰪ�� ��迡 �ִ� �ֵ�� ä�� ������ ��
	// 1base�� �ϸ� ĳ���� �ϴ� ��� -1 �� ä�� �־��� ��,
	// ���� �ʱ�ȭ�� �����൵ �ȴ�
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
		// �ʱ�ȭ
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
