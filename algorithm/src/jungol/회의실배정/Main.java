package jungol.회의실배정;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * 도서관 (문제번호 : 1370)
 * 
 * @category Greedy Algorithm
 * @since 2016.09.29
 * @author dongha
 */

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] meeting = new int[N][3];
 
        for (int i = 0; i < N; i++) {
            meeting[i][0] = sc.nextInt();
            meeting[i][1] = sc.nextInt();
            meeting[i][2] = sc.nextInt();
        }
         
        Arrays.sort(meeting, new Comp());
 
 
        int currentEnd = meeting[0][2];
        int currentStart = meeting[0][1];
        int cnt = 1;
        String Answer = meeting[0][0] + " ";
        for (int next = 1; next < N; next++) {
            int nextEnd = meeting[next][2];
            int nextStart = meeting[next][1];
            int num = meeting[next][0];
             
            if(nextStart >= currentEnd){
                currentStart = nextStart;
                currentEnd = nextEnd;
                cnt++;
                Answer = Answer + num +" ";
            }
        }
         
        System.out.println(cnt);
        System.out.println(Answer);
    }
}
 
class Comp implements Comparator<int[]> {
 
    @Override
    public int compare(int[] o1, int[] o2) {
        int endTime1 = o1[2];
        int endTime2 = o2[2];
 
        if (endTime1 > endTime2) {
            return 1;
        } else if (endTime1 == endTime2) {
            return 0;
        } else {
            return -1;
        }
    }
 
}