package jungol.영역구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/**
 * 영역 구하기 (문제번호 : 1457)
 * 
 * @category DFS
 * @since 2016.07.26
 * @author dongha
 */


public class Main {
    static final int[] dx = { 1, 0, -1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };
 
    static int M;
    static int N;
    static int K;
    static boolean[][] area;
    static ArrayList<Integer> emptyAreas;
    static int tot;
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        area = new boolean[M][N];
        emptyAreas = new ArrayList<Integer>();
        tot = 1;
        for (int i = 0; i < M; i++) {
            Arrays.fill(area[i], true);
        }
        int x1, y1, x2, y2;
        for (int i = 0; i < K; i++) {
            y1 = sc.nextInt();
            x1 = sc.nextInt();
            y2 = sc.nextInt() - 1;
            x2 = sc.nextInt() - 1;
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                area[j][k] = false;
                }
            }
        }
 
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(area[i][j]==false) continue;
                area[i][j] = false;
 
                dfs(i, j);
                emptyAreas.add(tot);
                tot = 1;
            }
        }
 
        Collections.sort(emptyAreas);
        System.out.println(emptyAreas.size());
        for(int ret : emptyAreas){
            System.out.print(ret +" ");
        }
    }
 
    private static void dfs(int x, int y) {
        int tmpX;
        int tmpY;
 
        for (int i = 0; i < 4; i++) {
            tmpX = x + dx[i];
            tmpY = y + dy[i];
            if (!isInRange(tmpX, tmpY))
                continue;
 
            if(area[tmpX][tmpY]==false) continue;
             
            area[tmpX][tmpY] = false;
             
            tot++;
            dfs(tmpX, tmpY);
        }
         
    }
 
    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
 
}