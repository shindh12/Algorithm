package jungol.도서관;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * 도서관 (문제번호 : 2247)
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
        int 최장이용시간 = 0;
        int 최않시 = 0;
        // 최대값 찾을때
        // 최소값 = 987654321;
 
        for (int next = 1; next < N; next++) {
            int nextStart = student[next][0];
            int nextEnd = student[next][1];
            if (curEnd >= nextStart) {
                // 겹친다
                curEnd = Math.max(curEnd, nextEnd);
            } else {
                // 안겹칠때
                최장이용시간 = Math.max(curEnd - curStart, 최장이용시간);
                최않시 = Math.max(nextStart - curEnd, 최않시);
                curStart = nextStart;
                curEnd = nextEnd;
            }
        }
        최장이용시간 = Math.max(최장이용시간, curEnd - curStart);
        System.out.println(최장이용시간 + " " + 최않시);
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