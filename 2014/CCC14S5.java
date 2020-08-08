
import java.io.*; import java.util.*;
public class CCC14S5 {
    public static class Point{
        int x; int y;
        public Point(int a, int b){
            this.x=a; this.y=b;
        }
    }
    public static class Dist implements Comparable<Dist>{
        int v1; int v2; int dist;
        public Dist(int a, int b, int c){
            this.v1=a; this.v2=b; this.dist=c;
        }
        public int compareTo(Dist other){
            if(this.dist<other.dist)return -1;
            if(this.dist>other.dist)return 1;
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Point[] p=new Point[N]; int a,b=0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            p[i]=new Point(a,b);
        }
        
        Dist[] dis=new Dist[(N*(N+1))/2];
        int cnt=0; int dist=0;
        for (int i =0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                dist=(p[i].x-p[j].x)*(p[i].x-p[j].x)+(p[i].y-p[j].y)*(p[i].y-p[j].y);
                dis[cnt]=new Dist(i,j, dist); cnt++;
            }
            dist=p[i].x*p[i].x+p[i].y*p[i].y;
            dis[cnt]=new Dist(i,N,dist); cnt++;
        }
        Arrays.sort(dis);
        
        int[] dp=new int[N+1]; 
        int[] curdist=new int[N+1];
        int[] save=new int[N+1];//Dealing with same distance
        //Can treat as previous distance
        //See analysis
        int saveb=0;
        for (int i = 0; i < (N*(N+1))/2; i++) {//This algorithm is inspired by 
            //dp[cur node][last dist]
            //But last dist takes up too much memory so we effectively evade it by noting how few transition values are there
            a=dis[i].v1; b=dis[i].v2;
            if(b==N){
                if(curdist[a]<dis[i].dist){
                    dp[b]=Math.max(dp[a]+1,dp[b]);
                    save[a]=dp[a];
                    curdist[a]=dis[i].dist;
                }else{
                    dp[b]=Math.max(save[a]+1,dp[b]);
                }
            }else{
                saveb=dp[b];//In case both (1), (2) happens
                if(curdist[a]<dis[i].dist){//(1)
                    dp[b]=Math.max(dp[a]+1,dp[b]);
                    save[a]=dp[a];
                    curdist[a]=dis[i].dist;
                }else{
                    dp[b]=Math.max(save[a]+1,dp[b]);
                }
                if(curdist[b]<dis[i].dist){//(2)
                    dp[a]=Math.max(saveb+1,dp[a]);
                    save[b]=saveb;
                    curdist[b]=dis[i].dist;
                }else{
                    dp[a]=Math.max(save[b]+1,dp[a]);
                }
               
            }
            
        }
        System.out.println(dp[N]);
    }
    
}
