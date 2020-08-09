import java.io.*; import java.util.*;
public class CCC14S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] x=new int[N]; int[] y=new int[N]; int a,b=0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            x[i]=Integer.parseInt(st.nextToken());
            y[i]=Integer.parseInt(st.nextToken());
            
        }
        
        long[] dis=new long[(N*(N+1))/2];
        int cnt=0; long dist=0;
        for (int i =0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                dist=(x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
                dis[cnt]=(long)(dist<<32)+i*(1<<16)+j; cnt++;
                
                
            }
            dist=x[i]*x[i]+y[i]*y[i];
            dis[cnt]=(long)(dist<<32)+i*(1<<16)+N; cnt++;
        }
        Arrays.sort(dis);
        
        int[] dp=new int[N+1]; 
        int[] curdist=new int[N+1];
        int[] save=new int[N+1];//Dealing with same distance
        //Can treat as previous distance
        //See analysis
        
        for (int i = 0; i < (N*(N+1))/2; i++) {//This algorithm is inspired by 
            //dp[cur node][last dist]
            //But last dist takes up too much memory so we effectively evade it by noting how few transition values are there
            
            
            a=(int) (dis[i]%((long)1<<32))/(1<<16); 
            b=(int) dis[i]%(1<<16);
            
            if(b==N){
                if(curdist[a]<(int) (dis[i]/(1<<30))/4){
                    dp[b]=Math.max(dp[a]+1,dp[b]);
                    save[a]=dp[a];
                    curdist[a]=(int) (dis[i]/(1<<30))/4;
                }else{
                    dp[b]=Math.max(save[a]+1,dp[b]);
                }
            }else{
                int saveb=dp[b];//In case both (1), (2) happens
                if(curdist[a]<(int) (dis[i]/(1<<30))/4){//(1)
                    dp[b]=Math.max(dp[a]+1,dp[b]);
                    save[a]=dp[a];
                    curdist[a]=(int) (dis[i]/(1<<30))/4;
                }else{
                    dp[b]=Math.max(save[a]+1,dp[b]);
                }
                if(curdist[b]<(int) (dis[i]/(1<<30))/4){//(2)
                    dp[a]=Math.max(saveb+1,dp[a]);
                    save[b]=saveb;
                    curdist[b]=(int) (dis[i]/(1<<30))/4;
                }else{
                    dp[a]=Math.max(save[b]+1,dp[a]);
                }
            }
            //System.out.println(a+" "+b+" "+Arrays.toString(dp));
        }
        System.out.println(dp[N]);
    }
    
}
