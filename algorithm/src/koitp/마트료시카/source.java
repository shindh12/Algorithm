package koitp.마트료시카;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 마트료시카
 * 
 * @category Dynamic Programming (LIS)
 * @since 2016.12.15
 * @author dongha
 */

public class source {
   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
               System.out));
       int N = Integer.parseInt(br.readLine());
       int[] 인형 = new int[N];
       StringTokenizer st = new StringTokenizer(br.readLine());
        
       for(int i=0;i<N;i++){
           인형[i] = Integer.parseInt(st.nextToken());
       }
       int[] D = new int[N];
       int size = 0;
       D[0] = 인형[0];
       for(int i=1;i<N;i++){
           int next = 인형[i];
           int now = D[size];
            
           if(next > now){
               size++;
               D[size] = next;
           }else{
               int idx = Arrays.binarySearch(D, 0, size, next);
               if(idx < 0 ) idx = Math.abs(idx) - 1;
               if(idx > size) idx = size;
                
               D[idx] = next;
           }
       }
       bw.write(String.valueOf(size+1));
       bw.flush();
       bw.close();
       br.close();
   }
}