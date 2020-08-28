import java.io.*; import java.util.*;
public class CCC20S5 {

    /**
     * DP+Math Optimization
     */
    static int MAXM=500001;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] b=new int[N];
        for (int i = 0; i < N; i++) {
            b[i]=Integer.parseInt(st.nextToken());
        }
        int[] a=new int[MAXM];
        
        for (int i = N-1; i >=1; i--) {
            if(a[b[i]]==0){
                a[b[i]]=i;
            }
        }
        
        double[] dp=new double[N];
        if(b[N-1]==b[0]){
            System.out.println(1); return;
        }
        dp[N-1]=0; dp[N-2]=0.5;
        int[] cnt=new int[MAXM];
        cnt[b[N-1]]++;
        cnt[b[N-2]]++;
        for (int i = N-2; i >=1; i--) {
            
            
            if(b[i]==b[0]){
                dp[i-1]=(double) (dp[i]*(N-i)+1)/(N-i+1);
                
            }else{
                dp[i-1]=(double) (dp[i]*(N-i)+dp[a[b[i]]])/(N-i+1);
            }
            cnt[b[i-1]]++;
        }
        
        System.out.println(dp[0]);
    }
    
}
