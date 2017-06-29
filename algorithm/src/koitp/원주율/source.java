package koitp.������;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * ������
 * 
 * @category �����̷� (���� Į�� �˰��� - ������ ���ϱ�)
 * @since 2016.11.04
 * @author dongha
 */

public class source {
    static final int N = 500000;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        br.close();
         
         
        double PI = 0;
        PI = getProbability(N);
 
        bw.write(String.format("%.2f", PI));
        bw.flush();
        bw.close();
    }
 
    /**
     * ���̰� 1�� �簢�� ���ο� ��п��� �ִٰ� ����
     */
    static double getProbability(int tot) {
        int cntInCircle = 0; // ��п� �ȿ� ������ ���� ���� 
        for (int i = 0; i < tot; i++) { // 
            double x = Math.random();
            double y = Math.random();
 
            if (x * x + y * y <= 1) { // ��п��� �ִ� ���̸� ī��Ʈ
                cntInCircle++;
            }
        }
        return (double) cntInCircle / tot * 4; // ��п��̴ϱ� ���ϱ� 4
    }
}