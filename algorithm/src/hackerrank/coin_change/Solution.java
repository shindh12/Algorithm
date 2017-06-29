package hackerrank.coin_change;

import java.util.Scanner;
/**
 * Coin Change Problem
 * 
 * @category Dynamic Programming
 * @since 2017.06.28
 * @author dongha
 */
public class Solution {

    static long getWays(int n, int[] c){
    	int m = c.length;
    	long[][] D = new long[m+1][n+1];
    	for(int i=0;i<=n;i+=c[0]){
    		D[1][i] = 1;
    	}
    	for(int i=2;i<=m;i++){
    		for(int j=0;j<=n;j++){
    			D[i][j] += D[i-1][j];
    			if(j-c[i-1] >= 0) D[i][j] += D[i][j-c[i-1]];
    		}
    	}
    	return D[m][n];
    }


	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}