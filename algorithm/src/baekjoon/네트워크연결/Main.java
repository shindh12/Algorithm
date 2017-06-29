package baekjoon.네트워크연결;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 네트워크 연결 (문제번호 : 1922)
 * Prim : 61360KB / 676 MS
 * Kruskal : 49532KB / 712 MS
 * 
 * @category MST (Prim, Kruskal)
 * @since 2016.11.10
 * @author dongha
 */
public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static PriorityQueue<int[]> kq;
	static int[] parent;
	static ArrayList[] G;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		G = new ArrayList[N];
		visited = new boolean[N];
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			G[i] = new ArrayList<Net>();
			parent[i] = i;
		}
		kq = new PriorityQueue<int[]>(M, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				int cost1 = o1[2];
				int cost2 = o2[2];
				
				return cost1 > cost2 ? 1 : -1;
			}
			
		}) ;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			int[] input = {from, to, cost};
			kq.add(input);
			G[from].add(new Net(to, cost));
			G[to].add(new Net(from, cost));
		}

		int kruAnswer = kruskal();
//		int primAnswer = prim(0);

		System.out.println(kruAnswer);
	}

	static int prim(int start) {
		int tot = 0;
		int cnt = 0;
		PriorityQueue<Net> pq = new PriorityQueue<Net>();
		pq.add(new Net(start, 0));
		while (!pq.isEmpty()) {
			Net c = pq.remove();
			if (visited[c.v] == true)
				continue;
			visited[c.v] = true;
			tot += c.cost;
			System.out.println(c.cost);
			cnt++;
			if (cnt == N)
				break;
			for (int i = 0; i < G[c.v].size(); i++) {
				Net n = (Net) G[c.v].get(i);
				pq.add(n);
			}
		}
		return tot;
	}

	static int kruskal() {
		int tot = 0;
		int cnt = 0;
		while(!kq.isEmpty()){
			if(cnt==N+1) break;
			int[] cur = kq.remove();
			int from = cur[0];
			int to = cur[1];
			int cost = cur[2];
			
			int fP = find(from);
			int tP = find(to);
			if(fP==tP) continue;
			
			tot += cost;
			union(from, to);

			cnt++;
		}
		
		
		return tot;
	}

	static int find(int v) {
		if (parent[v] == v)
			return v;
		else
			return find(parent[v]);
	}

	static void union(int i, int j) {
		int iSet = find(i);
		int jSet = find(j);
		if (iSet == jSet) {
			return;
		}
		parent[jSet] = iSet;
	}
}

class Net implements Comparable<Net> {
	int v;
	int cost;

	public Net(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}

	@Override
	public int compareTo(Net o) {
		return o.cost < cost ? 1 : -1;
	}
}