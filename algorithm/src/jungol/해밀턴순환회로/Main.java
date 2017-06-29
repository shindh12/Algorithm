package jungol.해밀턴순환회로;

import java.util.Scanner;
/**
 * 해밀턴 순환 회로 (문제번호 : 1681)
 * 
 * @category DFS
 * @since 2016.07.26
 * @author dongha
 */

public class Main{
    static final int INF = 987654321;
    static int N;
    static int[][] path;
    static boolean[] visited;
    static int[][] cache;
    static int minAns;
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        N = sc.nextInt();
        path = new int[N][N];
        cache = new int[N][N];
 
        visited = new boolean[N];
        minAns = INF;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                path[i][j] = sc.nextInt();
            }
        }
        visited[0] = true;
        dfs(0, 1, 0);
        System.out.println(minAns);
    }
 
    public static void dfs(int from, int pickCnt, int tot) {
        if (tot >= minAns)
            return;
         
        if (pickCnt == N) {
            if (path[from][0] == 0)
                return;
            minAns = Math.min(minAns, tot + path[from][0]);
            return;
        }
        for (int to = 1; to < N; to++) {
            if (path[from][to] == 0)
                continue;
            if (visited[to] == true)
                continue;
     
 
            visited[to] = true;
            dfs(to, pickCnt + 1, tot + path[from][to]);
            visited[to] = false;
        }
    }
}