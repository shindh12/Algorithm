package koitp.내리막길;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 내리막길
 * 
 * @category Dynamic Programming
 * @since 2016.12.07
 * @author dongha
 */
public class source {
    static final int MOD = 1234567;
    static final int[] dx = { 0, -1, 0, 1 }; // 오른쪽부터 반시계 방향
    static final int[] dy = { 1, 0, -1, 0 };
 
    static int M;
    static int N;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] G = new int[M][N];
        ArrayList<Point> p = new ArrayList<Point>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                p.add(new Point(i, j, G[i][j]));
            }
        }
        Collections.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.h < o2.h ? -1 : 1;
            }
        });
        int[][] D = new int[M][N];
        Point start = p.get(0);
        D[start.x][start.y] = 1; // 부분 문제
 
        for (int k = 0; k < M * N; k++) {
            Point now = p.get(k);
            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (!isInRange(tmpx, tmpy)) continue;
                if (G[now.x][now.y] <= G[tmpx][tmpy]) continue;
 
                D[now.x][now.y] = (D[now.x][now.y] + D[tmpx][tmpy]) % MOD;
            }
        }
        bw.write(String.valueOf(D[0][0]));
        bw.flush();
        bw.close();
        br.close();
    }
 
    static boolean isInRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
 
class Point {
    int x;
    int y;
    int h;
 
    public Point(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}