import java.io.*; import java.util.*;
//The solution is motivated by the fact that we can get sth optimal by having 1 or 0 pies between fixed pies
//Then some greedy suffice
//Even though some observations there are unnecessary, still leads me to a solution 
//Memory Compression
public class CCC15S5 {
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        
    } 
    public static void main(String[] args) throws IOException {
        FastReader br=new FastReader();
        int N=br.nextInt();
        int[] a=new int[N];
        for (int i = 0; i < N; i++) {
            a[i]=br.nextInt();
        }
        int M=br.nextInt();
        int[] b=new int[M];
        for (int i = 0; i < M; i++) {
            b[i]=br.nextInt();
        }
        Arrays.sort(b);
        
        int[][][] dp=new int[M+1][M+1][2];
        int[][][] dp2=new int[M+1][M+1][2];//Memory Compression: Java is slow when there is too much memory
        for (int i = 1; i <= M; i++) {
            dp[0][i][0]=dp[0][i-1][1];
            dp[0][i][1]=Math.max(dp[0][i][0],dp[0][i-1][0]+b[M-i]);
            dp[i][0][0]=dp[i-1][0][1];
            dp[i][0][1]=Math.max(dp[i][0][0],dp[i-1][0][0]+b[i-1]);
            
        }
        for (int i = 1; i <=M; i++) {
            for (int j = 1; j <=M; j++) {
               
                dp[i][j][0]=Math.max(dp[i][j-1][1],dp[i-1][j][1]);
                dp[i][j][1]=Math.max(dp[i][j][0], Math.max(dp[i][j-1][0]+b[M-j], dp[i-1][j][0]+b[i-1]));
                
            }
        }
        
        for (int i = 1; i <=N; i++) {
            dp2[0][0][0]=dp[0][0][1];
            dp2[0][0][1]=Math.max(dp2[0][0][0],dp[0][0][0]+a[i-1]);
            
            for (int j = 1; j <=M; j++) {//First evaluate dp[i][0][j][.]
                
                dp2[0][j][0]=Math.max(dp[0][j][1], dp2[0][j-1][1]);
                dp2[0][j][1]=Math.max(dp2[0][j][0],Math.max(dp[0][j][0]+a[i-1], dp2[0][j-1][0]+b[M-j]));
                
                dp2[j][0][0]=Math.max(dp[j][0][1], dp2[j-1][0][1]);
                dp2[j][0][1]=Math.max(dp2[j][0][0],Math.max(dp[j][0][0]+a[i-1], dp2[j-1][0][0]+b[j-1]));
                
            }
            for (int j = 1; j <=M; j++) {
                for (int k = 1; k <=M-j; k++) {
                    dp2[j][k][0]=Math.max(dp[j][k][1], Math.max(dp2[j-1][k][1], dp2[j][k-1][1]));
                    dp2[j][k][1]=Math.max(dp2[j][k][0],Math.max(dp[j][k][0]+a[i-1], Math.max(dp2[j-1][k][0]+b[j-1], dp2[j][k-1][0]+b[M-k])));
                }
                
            }
            dp=dp2.clone();
            dp2=new int[M+1][M+1][2];
        }
        int ans=0;
        
        for (int i = 0; i <=M; i++) {
            ans=Math.max(ans, dp[i][M-i][1]);
            
        }
        
        System.out.println(ans);
    }
    
}
