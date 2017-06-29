package baekjoon.경로찾기;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 경로 찾기 (문제번호 : 11403)
 * 
 * @category DFS
 * @since 2016.07.26
 * @author dongha
 */
public class Main {
	static int[][] path;
	static boolean[] visited;
	static boolean[][] dist;
	static int N;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

			N = sc.nextInt();
			path = new int[N][N];
			visited = new boolean[N];
			dist = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					path[i][j] = sc.nextInt();
				}
			}
			for (int from = 0; from < N; from++) {
				Arrays.fill(visited, false);
				dfs(from);
				for(int i=0;i<N;i++){
					if(visited[i]) dist[from][i] = true;
				}
			}
			printPath();
	}

	public static void printPath() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] == false)
					System.out.print("0 ");
				else
					System.out.print("1 ");
			}
			System.out.println();
		}
	}

	public static void dfs(int from) {

		for (int to = 0; to < N; to++) {
			if (visited[to] == true)
				continue;
			if (path[from][to] == 0)
				continue;
			visited[to] = true;
			dfs(to);
		}
	}
}