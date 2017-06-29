package koitp.�����Ҽ����ǰ���;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * ���� �Ҽ����� ����
 * 
 * @category Data Structure (�켱���� ť)
 * @since 2016.12.04
 * @author dongha
 */

public class source {
 
    static final int N = 5842;
 
    static final int[] prime = { 2, 3, 5, 7 };
 
    static long[] R;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        R = new long[N];
        init();
 
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine()) - 1;
            bw.write(String.valueOf(R[n])+"\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
 
    /**
     * ����� ��ó��
     */
    private static void init() {
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        int length = prime.length;
        int cnt = 0;
        q.add(1l); // ���� 1���� ����
        while (!q.isEmpty()) {
            if (cnt > N - 1) // 5842�� ������
                break;
            long current = q.remove(); // ����������� �� ����
            R[cnt] = current; 
            cnt++;
            for (int i = 0; i < length; i++) {
                long next = current * prime[i]; // ���� ������� 2, 3, 5, 7�� ����
                if (q.contains(next)) continue; // �̹� �ִ� ���ڸ� �߰���Ű�� ����
                q.add(next);
            }
        }
    }
}