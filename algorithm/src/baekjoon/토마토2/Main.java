package baekjoon.토마토2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토(2차원) (문제번호 : 7576)
 * 
 * @category BFS
 * @since 2016.07.25
 * @author dongha
 */

public class Main {
	static final int[] dn = { 0, -1, 0, 1 }; // 우 상 좌 하
	static final int[] dm = { 1, 0, -1, 0 };

	static final int MAX = 1000;

	static int N;
	static int M;
	static int noTomatoCnt;
	static Queue<Location> queue;
	static boolean[][] visited;
	static int[][] storage;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// int T = sc.nextInt();

		// for (int test_case = 1; test_case <= T; test_case++) {
		M = sc.nextInt();
		N = sc.nextInt();
//		queue.clear();
//		clearStorage();
		queue = new LinkedList<Location>();
		visited = new boolean[N][M];
		storage = new int[N][M];
		noTomatoCnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int num = sc.nextInt();
				storage[i][j] = num;
				if (num == 1) {
					visited[i][j] = true;
					queue.add(new Location(i, j));
				} else if (num == 0) {
					noTomatoCnt++;
				}

			}
		}

		System.out.println(bfs());
		// System.out.println("#" + test_case + " " + bfs());
		// }
	}

	private static void clearStorage() {
		for (int i = 0; i < MAX; i++) {
			Arrays.fill(storage[i], 0);
			Arrays.fill(visited[i], false);
		}
	}

	private static int bfs() {
		if(noTomatoCnt==0) return 0;
		
		int day = 0;
		while (!queue.isEmpty()) {
			Location cur = queue.remove();
			int tmpX;
			int tmpY;
			for (int i = 0; i < 4; i++) {
				tmpX = cur.x + dn[i];
				tmpY = cur.y + dm[i];

				if (!isInRange(tmpX, tmpY))
					continue;
				if(visited[tmpX][tmpY]==true) 
					continue;
				if (storage[tmpX][tmpY] == -1)
					continue;
				
				queue.add(new Location(tmpX, tmpY));
				noTomatoCnt--;
				day = storage[tmpX][tmpY] = storage[cur.x][cur.y] + 1;
				visited[tmpX][tmpY] = true;
			}
		}

		return noTomatoCnt == 0 ? day -1 : -1;
	}

	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}

}