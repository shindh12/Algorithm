package jungol.토마토_고;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 토마토(고) (문제번호 : 2613)
 * 
 * @category BFS
 * @since 2016.10.28
 * @author dongha
 */


public class Main {
    static final int[] dn = { 0, -1, 0, 1 }; // 우 상 좌 하
    static final int[] dm = { 1, 0, -1, 0 };
  
    static final int MAX = 1000;
  
    static int N;
    static int M;
    static int noTomatoCnt;
    static Queue<Integer> queue;
    static boolean[][] visited;
    static int[][] storage;
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
  
        queue = new LinkedList<Integer>();
        visited = new boolean[N][M];
        storage = new int[N][M];
        noTomatoCnt = 0;
          
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(input2[j]);
                storage[i][j] = num;
                if (num == 0) {
                    noTomatoCnt++;
                } else if (num == 1) {
                    visited[i][j] = true;
                    queue.add(i * M + j);
                }
  
            }
        }
        br.close();
        System.out.println(bfs());
    }
  
    private static int bfs() {
        if(noTomatoCnt==0) return 0;
          
        int day = 0;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int x = cur / M;
            int y = cur % M;
            int tmpX, tmpY;
            for (int i = 0; i < 4; i++) {
                tmpX = x + dn[i];
                tmpY = y + dm[i];
  
                if (!isInRange(tmpX, tmpY))
                    continue;
                if(visited[tmpX][tmpY]==true) 
                    continue;
                if (storage[tmpX][tmpY] == -1)
                    continue;
                  
                queue.add(tmpX * M + tmpY);
                noTomatoCnt--;
                day = storage[tmpX][tmpY] = storage[x][y] + 1;
                visited[tmpX][tmpY] = true;
            }
        }
  
        return noTomatoCnt == 0 ? day -1 : -1;
    }
  
    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}