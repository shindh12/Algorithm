package baekjoon.이공사팔;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 2048 (EASY) (문제번호: 12100)
 * 
 * @category Brute Force
 * @since 2020.01.07
 * @author dongha
 */

public class Main {
	public static final int[] dx = { 0, 0, 1, -1 }; // 동서남북
	public static final int[] dy = { 1, -1, 0, 0 };

	public static final int MIN = -1;
	
	public static final int EAST = 0;
	public static final int WEST = 1;
	public static final int SOUTH = 2;
	public static final int NORTH = 3;
	
	public static final int LIMIT = 5;

	public static int[][] board;
	public static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(String.valueOf(move(1)));
		bw.flush();
		bw.close();
	}

	private static int move(int n) {
		int result = MIN;
//		Queue<Integer> q = new LinkedList<>();
		Deque<Integer> dq = new LinkedList<>();
		if (n > LIMIT) {
			result = getMaxValue(board);
			return result;
		}
		int[][] now = getCopiedBoard(board);
		
		// 동서남북 에서 밀 때
		for (int d = 0; d < 4; d++) {
			for(int i = 0;i < N; i++) {
				int x, y;
				// 동서남북 밀 때 첫 위치
				if(d==EAST) {
					x = i;
					y = 0;
				}else if (d==WEST){
					x = i;
					y = N-1;
				}else if (d==SOUTH) {
					x = 0;
					y = i;
				}else {
					x = N-1;
					y = i;
				}
				int nx = x;
				int ny = y;
				for(int j = 0; j < N; j++) {
					// 값이 0이 아니면 q에 배열 값 넣음
					if(board[nx][ny] != 0) {
						dq.add(board[nx][ny]);
						board[nx][ny] = 0;
					}
					nx = nx + dx[d];
					ny = ny + dy[d];
				}
				
				nx = x; ny = y;
				// q에서 빼면서 밀어넣어
				while(!dq.isEmpty()) {
					int val;
					if(d % 1 == 0) { // 오른쪽이나 아래쪽으로 할 때 반대로 할 경우
						val = dq.pollFirst();
					}else {
						val = dq.pollLast();
					}
					// 현재 위치 값 0 이면 일단 넣어
					if(board[nx][ny] == 0) {
						board[nx][ny] = val;
					} else if (board[nx][ny] == val){
						// 이전 값이랑 뽑은 값이 같으면 두개 더해
						board[nx][ny] += val;
						nx += dx[d]; ny += dy[d];
					} else {
						// 다른 값이면 다음 자리에 값을 넣음
						nx += dx[d]; ny += dy[d];
						board[nx][ny] = val;
					}
				}
			}
			result = Math.max(move(n+1), result);
			// 다른 분기로 가기 전에 이전 보드판으로 초기화
			board = getCopiedBoard(now);
		}

		
		return result;
	}

	private static int getMaxValue(int[][] b) {
		int max = MIN;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(b[i][j], max);
			}
		}
		return max;
	}

	private static int[][] getCopiedBoard(int[][] org) {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			copy[i] = Arrays.copyOf(org[i], N);
		}

		return copy;
	}

}
