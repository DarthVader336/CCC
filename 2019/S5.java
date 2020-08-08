import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class S5 {

    static double key=1.5;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        long[][] a=new long[N][N];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            
            for (int j = 0; j <=i; j++) {
               a[i][j]=Long.parseLong(st.nextToken());
            }
        }
        long sum=0;
        if(K==1){
            for(int i=0;i<N;i++){
                for(int j=0;j<=i;j++){
                    sum+=a[i][j];
                }
            } 
            System.out.println(sum); return;
        }
        
        for(int i=0;i<N-1;i++){
            for (int j = 0; j <=i; j++) {
                a[i][j]=Math.max(a[i][j],Math.max(a[i+1][j],a[i+1][j+1]));
                
            }
            
        }
        int done=2; int min=0; 
        while(done<K){
            min=Math.min(((done*3)/2),K);
            
            for(int i=0;i<=N-min;i++){
                for(int j=0;j<=i;j++){
                    a[i][j]=Math.max(a[i][j],
                            Math.max(a[i+min-done][j],a[i+min-done][j+min-done]));
                }
            }
            done=min;
            
        }
        for (int i = 0; i <=N-K; i++) {
            for (int j = 0; j <=i; j++) {
                sum+=a[i][j];
                
            }
        }
        System.out.println(sum);
    }
    
}
