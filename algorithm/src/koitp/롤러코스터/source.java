package koitp.�ѷ��ڽ���;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * �ѷ� �ڽ���
 * 
 * @category Dynamic Programming
 * @since 2016.12.06
 * @author dongha
 */

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
 
        ArrayList[] go = new ArrayList[L + 1]; // go[i] �� i ��ġ�� ������ ��ǰ���� ���� ��ȣ��
        Part[] input = new Part[N];
        for (int i = 0; i <= L; i++) {
            go[i] = new ArrayList<Part>();
        }
        int[][] D = new int[L + 1][B + 1];
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); // from
            int to = from + Integer.parseInt(st.nextToken()); // to
            int fun = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            input[i] = new Part(from, to, fun, cost);
            if (to <= L)
                go[to].add(input[i]);
 
            if (from == 0 && to <= L) {
                D[to][cost] = fun;
            }
        }
 
        for (int to = 1; to <= L; to++) {
            for (int j = 0; j <= B; j++) {
                for (int prev = 0; prev < go[to].size(); prev++) {
                    Part tmp = (Part) go[to].get(prev);
                    int fun = tmp.fun;
                    int cost = tmp.cost;
                    int from = tmp.from;
                    if (j >= cost && D[from][j - cost] != 0) {
                        D[to][j] = Math.max(D[to][j], D[from][j - cost] + fun);
                    }
                }
            }
        }
 
     
        int Answer = -1;
 
        for (int i = 0; i <= B; i++) {
            if (D[L][i] != 0)
                Answer = Math.max(Answer, D[L][i]);
        }
 
        bw.write(String.valueOf(Answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
 
class Part {
    int from;
    int to;
    int fun;
    int cost;
 
    public Part(int from, int to, int fun, int cost) {
        this.from = from;
        this.to = to;
        this.fun = fun;
        this.cost = cost;
    }
 
}