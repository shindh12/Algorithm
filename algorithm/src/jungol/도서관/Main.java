package jungol.������;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * ������ (������ȣ : 2247)
 * 
 * @category Greedy Algorithm
 * @since 2016.09.29
 * @author dongha
 */

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] student = new int[N][2];
 
        for (int i = 0; i < N; i++) {
            student[i][0] = sc.nextInt();
            student[i][1] = sc.nextInt();
        }
 
        Arrays.sort(student, new StuComp());
                 
         
        int curStart = student[0][0];
        int curEnd = student[0][1];
        int �����̿�ð� = 0;
        int �־ʽ� = 0;
        // �ִ밪 ã����
        // �ּҰ� = 987654321;
 
        for (int next = 1; next < N; next++) {
            int nextStart = student[next][0];
            int nextEnd = student[next][1];
            if (curEnd >= nextStart) {
                // ��ģ��
                curEnd = Math.max(curEnd, nextEnd);
            } else {
                // �Ȱ�ĥ��
                �����̿�ð� = Math.max(curEnd - curStart, �����̿�ð�);
                �־ʽ� = Math.max(nextStart - curEnd, �־ʽ�);
                curStart = nextStart;
                curEnd = nextEnd;
            }
        }
        �����̿�ð� = Math.max(�����̿�ð�, curEnd - curStart);
        System.out.println(�����̿�ð� + " " + �־ʽ�);
    }
}
 
class StuComp implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        int endTime1 = o1[1];
        int endTime2 = o2[1];
        int startTime1 = o1[0];
        int startTime2 = o2[0];
         
        if (startTime1 > startTime2) {
            return 1;
        } else if (startTime1 == startTime2) {
            if(endTime1 > endTime2){
                return 1;
            }else if (endTime1 == endTime2){
                return 0;
            }else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}