package koitp.보물섬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 보물섬
 * 
 * @category Graph (다익스트라)
 * @since 2016.11.07
 * @author dongha
 */

public class source {
    static final int INF = 987654321;
    static int[][] G;
    static int[] dist;
    static boolean[] visited;
    static int N;
    static int M;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                System.out));
 
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        G = new int[N][N];
 
        dist = new int[N];
        visited = new boolean[N];
        int F = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            int cost = Integer.parseInt(input[2]);
            Node next = new Node(to, cost);
            if (G[from][to] != 0)
                G[from][to] = Math.min(G[from][to], cost);
            else
                G[from][to] = cost;
        }
        Arrays.fill(dist, INF);
        int go = dijkstra(0, F);
        if (go == INF)
            bw.write("NO\n");
        else {
            Arrays.fill(dist, INF);
            Arrays.fill(visited, false);
            int back = dijkstra(F, 0);
            if (back == INF) bw.write("NO\n");
            else bw.write("YES\n" + (go + back) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
 
    private static int dijkstra(int S, int F) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Node start = new Node(S, 0);
        pq.add(start);
        dist[S] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.remove();
            int v = current.v;
            int cost = current.cost;
            visited[v] = true;
            for (int n = 0; n < N; n++) {
                if (G[v][n] == 0)
                    continue;
                if (visited[n] == true)
                    continue;
 
                if (dist[n] > cost + G[v][n]) {
                    dist[n] = cost + G[v][n];
                    pq.add(new Node(n, dist[n]));
                }
            }
        }
        return dist[F];
    }
}
 
class Node implements Comparable<Node> {
    int v;
    int cost;
 
    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
 
    @Override
    public String toString() {
        return "Node [v=" + v + ", cost=" + cost + "]";
    }
 
    @Override
    public int compareTo(Node o) {
        if (o.cost == cost)
            return 0;
        return o.cost > cost ? -1 : 1;
    }
 
}