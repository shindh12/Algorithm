package koitp.피크닉;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 피크닉
 * 
 * @category Graph (다익스트라)
 * @since 2016.12.02
 * @author dongha
 */


public class source {
    static int K;
    static int N;
    static int M;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                System.out));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        int[] pos = new int[K];
        for (int i = 0; i < K; i++) {
            pos[i] = Integer.parseInt(br.readLine()) - 1;
        }
        ArrayList[] G = new ArrayList[N];
        // int[][] G = new int[N][N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<Integer>();
        }
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            G[from].add(to);
        }
        int cnt = 0;
        int[] Answer = new int[N];
        for (int s = 0; s < K; s++) {
            Queue<Integer> q = new LinkedList<Integer>();
            int start = pos[s];
            boolean[] visited = new boolean[N];
            q.add(start);
            visited[start] = true;
            while (!q.isEmpty()) {
                int now = q.remove();
                Answer[now]++;
                if(Answer[now]==K) cnt++;
                int size = G[now].size();
                for (int i = 0; i < size; i++) {
                    int next = (int) G[now].get(i);
                    if(visited[next]==true) continue;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}