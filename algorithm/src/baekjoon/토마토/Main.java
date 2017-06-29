package baekjoon.�丶��;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * �丶�� (������ȣ : 7569)
 * 
 * @category BFS
 * @since 2016.04.22
 * @author dongha
 */

public class Main {
	static final int NONE_TOMATO_VAL = -1;
	static final int UNGROWN_TOMATO_VAL = 0;
	static final int GROWN_TOMATO_VAL = 1;

	static final int UNGROWN = -1;

	static final int[] dm = { 1, -1, 0, 0, 0, 0 }; // -> M ������
	static final int[] dn = { 0, 0, -1, 1, 0, 0 }; // -> N ������
	static final int[] dh = { 0, 0, 0, 0, -1, 1 }; // -> H ������

	static int H; // [H][N][M]
	static int N;
	static int M;

	static int[][][] boxes;

	static Queue q = new LinkedList<Point>();
	static HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		boxes = new int[H][N][M];

		int ungrown_tomato_cnt = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					boxes[i][j][k] = sc.nextInt();
					if (boxes[i][j][k] == 0) {
						ungrown_tomato_cnt++;
					}
				}
			}
		} // �Է�
		Main t = new Main();
		System.out.println(t.countGrownDay(ungrown_tomato_cnt));
		// ��� �޾Ҵµ� ungrown_tomato_cnt�� 0�� �ƴϸ� -1
	}

	public int countGrownDay(int ungrown) {
		if (ungrown == 0)
			return 0; // �� �ڶ������� ���� 0

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (boxes[i][j][k] == 1) {
						Point tomato = new Point(i, j, k);
						q.add(tomato);
						visited.put(getKey(tomato), true);
					}
				}
			}
		} // �ʱ� �丶��� ��� Queue�� ����
		int day = 0;

		while (!q.isEmpty()) {
			Point c = (Point) q.remove();
			for (int i = 0; i < 6; i++) {
				int tmpN = c.n + dn[i];
				int tmpM = c.m + dm[i];
				int tmpH = c.h + dh[i];

				Point next = new Point(tmpH, tmpN, tmpM);
				// System.out.println(next.toString());
				if (!isInRange(next))
					continue;
				if (!isPossible(next))
					continue;

				day = boxes[tmpH][tmpN][tmpM] = boxes[c.h][c.n][c.m] + 1;
				q.add(next);
				visited.put(getKey(next), true);
				ungrown--;
			}

		}
		return (ungrown == 0) ? day -1 : UNGROWN;
	}


	private static int getKey(Point p) {
		return p.h * M * N + p.n * M + p.m; // �ٽ�
	}

	private static boolean isInRange(Point p) {

		return (p.n >= 0 && p.n < N && p.m >= 0 && p.m < M && p.h >= 0 && p.h < H) ? true : false;
	}

	private static boolean isPossible(Point p) {

		if (boxes[p.h][p.n][p.m] == -1)
			return false;

		if (visited.containsKey(getKey(p)))
			return false;

		return true;
	}

	public class Point {
		int n;
		int m;
		int h;

		public Point(int h, int n, int m) {
			this.n = n;
			this.m = m;
			this.h = h;
		}

	}
}