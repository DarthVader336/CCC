import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5 {

    static double key=1.5;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] t=br.readLine().split("\\ ");
        int N=Integer.parseInt(t[0]);
        int K=Integer.parseInt(t[1]);
        int[][] a=new int[N][N];
        for (int i = 0; i < N; i++) {
            t=br.readLine().split("\\ ");
            for (int j = 0; j <=i; j++) {
               a[i][j]=Integer.parseInt(t[j]);
            }
        }
        long sum=0;
        if(K==1){
            for(int i=0;i<N;i++){
                for(int j=0;j<=i;j++){
                    sum+=(long)a[i][j];
                }
            }
            System.out.println(sum); return;
        }
        int[][] max=new int[N-1][N-1];
        //max[i][j]= max(a[i][j], a[i+1][j], a[i+1][j+1])
        for(int i=0;i<N-1;i++){
            for (int j = 0; j <=i; j++) {
                max[i][j]=Math.max(a[i][j],Math.max(a[i+1][j],a[i+1][j+1]));
                
            }
            
        }
        int done=2; int min=0; int[][] max2;
        while(done<K){
            min=Math.min((int)(done*key),K);
            max2=new int[N-min+1][N-min+1];
            for(int i=0;i<=N-min;i++){
                for(int j=0;j<=i;j++){
                    max2[i][j]=Math.max(max[i][j],
                            Math.max(max[i+min-done][j],max[i+min-done][j+min-done]));
                }
            }
            done=min;
            max=new int[N-min+1][N-min+1];
            for(int i=0;i<=N-min;i++){
                for(int j=0;j<=i;j++){
                    max[i][j]=max2[i][j];
                }
            }
        }
        for (int i = 0; i <=N-K; i++) {
            for (int j = 0; j <=i; j++) {
                sum+=(long)max[i][j];
                
            }
        }
        System.out.println(sum);
    }
    
}
