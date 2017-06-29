package jungol.숫자카드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * 숫자카드 (문제번호 : 1407)
 * 
 * @category Dynamic Programming
 * @since 2016.10.28
 * @author dongha
 */


public class Main {
    static final int MAX = 34;
    static int N;
    static String str;
    static int[] cache;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
 
        N = str.length();
        cache = new int[N + 1];
        // String Answer = number.substring(0, 2);
        int Answer = dp(0);
 
        System.out.println(Answer);
    }
 
    private static int dp(int n) {
        if (n >= N) return 1;
 
        if (cache[n] != 0)
            return cache[n];
 
        if (n + 1 > N || Integer.parseInt(str.substring(n, n + 1)) < 1)
            return 0;
        int a = dp(n + 1);
        if (n + 2 > N || Integer.parseInt(str.substring(n, n + 2)) > MAX)
            return cache[n] = a;
         
        int b = dp(n + 2);
 
        return cache[n] = a + b;
 
    }
}