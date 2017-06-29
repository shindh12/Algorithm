package jungol.저글링방사능오염;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 저글링 방사능 오염 (문제번호 : 1078)
 * 
 * @category BFS
 * @since 2016.04.21
 * @author dongha
 */


public class Main {
    static int N; // 가로
    static int M; // 세로
    static int count;
    static int[][] map;
    static HashMap<Integer, Boolean> visited;
    // 방문했는지 확인
 
    // R, L, U, D
    static final int[] dx = { 0, 0, -1, 1 };
    static final int[] dy = { 1, -1, 0, 0 };
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[M][N];
        visited = new HashMap<Integer, Boolean>();
        for (int i = 0; i < M; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt("" + line.charAt(j));
                if(map[i][j]==1) count++; // 저글링 마리수
            }
        }
        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;
        Main s = new Main();
        System.out.println(s.killZergling(startY, startX));
        System.out.println(count);
 
    }
 
    public int killZergling(int x, int y) {
        Queue q = new LinkedList<Point>();
        Point start = new Point(x, y);
        int max = 3;
        map[x][y] = 3;
        q.add(start);
        count--;
 
        visited.put(getIndex(x, y), true);
        while (!q.isEmpty()) {
            Point current = (Point) q.remove();
            for (int i = 0; i < 4; i++) {
                int tmpX = current.x + dx[i];
                int tmpY = current.y + dy[i];
                 
                if(!isInRange(tmpX, tmpY)) continue;
                if(map[tmpX][tmpY]==0) continue;
                if(visited.containsKey(getIndex(tmpX, tmpY)))
                    continue;
 
                Point next = new Point(tmpX, tmpY);
                map[tmpX][tmpY] += map[current.x][current.y];
                if(max < map[tmpX][tmpY]) max = map[tmpX][tmpY];
                visited.put(getIndex(tmpX, tmpY), true);
                q.add(next);
                count--;
            }
        }
        return max;
    }
 
    private boolean isInRange(int x, int y) {
        return (x >= 0 && x < M && y >= 0 && y < N) ? true : false;
    }
 
    private int getIndex(int x, int y) {
        return N * x + y;
    }
 
    class Point {
        int x, y;
 
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}