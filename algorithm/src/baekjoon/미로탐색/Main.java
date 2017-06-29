package baekjoon.미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로 찾기 (문제번호 : 2178)
 * 
 * @category BFS
 * @since 2016.04.16
 * @author dongha
 */
public class Main {
	private final static int VISITED = 1;
	private final static int UNVISITED = 0;
	final static int dx[] = {1, 0, -1, 0};
	final static int dy[] = {0, -1, 0, 1};
	
	static int maze[][];
	static int visit[][];
	static int N, M;	
	
	
	public static void main(String[] args) throws Exception {
		 Scanner sc = new Scanner(System.in);
	//	Scanner sc = new Scanner(new FileInputStream("maze_input.txt"));

		int TC = 1;
		int test_case;

		//TC = sc.nextInt();

		for (test_case = 1; test_case <= TC; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			maze = new int[N][M];
			visit = new int[N][M];
			for(int i = 0; i < N; i++){
				String tmp = sc.next();
				for(int j=0; j < tmp.length(); j++){
					maze[i][j] = tmp.charAt(j) - '0';
				}
			}
			System.out.println(new Main().bfs());
		}
	}
	public int bfs(){
		Queue queue = new LinkedList<Point>();
		Point f = new Point(0, 0);
		Point end = new Point(N-1, M-1);
		queue.add(f);
		visit[f.x][f.y] = VISITED;
		
		while(!queue.isEmpty()){
			Point n = (Point)queue.remove();
			if((n.x==end.x)&&(n.y==end.y)) break;
			

			for(int i = 0; i < 4; i++){
				int tmpX, tmpY;
				tmpX = n.x + dx[i];
				tmpY = n.y + dy[i];
				Point tPoint = new Point(tmpX, tmpY);
				if(!isRange(tPoint.x, tPoint.y)) continue;
				if(maze[tmpX][tmpY]==0) continue;
				
				if(visit[tPoint.x][tPoint.y]==UNVISITED){
					queue.add(tPoint);
					visit[tPoint.x][tPoint.y] = VISITED;
					maze[tPoint.x][tPoint.y] += maze[n.x][n.y];
				}
			}
		}
		
		return maze[N-1][M-1];
	}

	public boolean isRange(int x, int y){
		return (x>=0&&y>=0&&x<N&&y<M) ? true : false;
	}
	class Point{
		int x, y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}