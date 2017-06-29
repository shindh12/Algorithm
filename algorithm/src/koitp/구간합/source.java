package koitp.구간합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 구간합
 * 
 * @category Data Structure (세그먼트 트리?)
 * @since 2016.12.29
 * @author dongha
 */


public class source {
	static final int MAX = (int) Math.pow(2, 18);
	static int[] data;
	static long[] tree = new long[MAX + 1];
	static int N;
	static int Q;
	static int S; // Tree에서 데이터가 시작하는 위치

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		Q = Integer.parseInt(br.readLine());
		S = 1;
		data = new int[N + 1];
		init();
		for (int q = 1; q <= Q; q++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (type == 0) {
				data[x] = y;
				put(S + x - 1, y);
			} else {
				bw.write(String.valueOf(get(x, y) + "\n"));
				bw.flush();
			}
		}
		bw.close();
		br.close();
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(tree[S + i]);
		}
		System.out.println();
	}
	
	// 배열 데이터를 트리로 만들기
	private static void init() {
		while (S < N) {
			S *= 2;
		}

		for (int i = 0; i < N; i++) {
			tree[S + i] = i + 1;
			data[i + 1] = i + 1;

			put(S + i, data[i + 1]);
		}
	}
	
	//data put
	private static void put(int pos, int val) {
		tree[pos] = val;
		while (pos > 0) {
			int tmp = pos / 2;
			tree[tmp] = tree[tmp * 2] + tree[tmp * 2 + 1];
			pos /= 2;
		}
	}
	
	// data get
	private static long get(int x, int y) {
		int l = x + S - 1;
		int r = y + S - 1;
		long s = 0;

		while (l <= r) {
			if (l % 2 == 1) {
				s += tree[l];
				l += 1;
			}

			if (r % 2 == 0) {
				s += tree[r];
				r -= 1;
			}
			r /= 2;
			l /= 2;
		}
		return s;
	}
}