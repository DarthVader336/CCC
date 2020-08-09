import java.io.*; import java.util.*;
public class CCC08S3 {
    public static class Pair{
        int r; int c;
        public Pair(int a, int b){
            this.r=a; this.c=b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine()); Pair p;
        for (int i = 0; i < T; i++) {
            int r=Integer.parseInt(br.readLine());
            int c=Integer.parseInt(br.readLine());
            char[][] arr=new char[r][c];
            for (int j = 0; j < r; j++) {
                String str=br.readLine();
                for (int k = 0; k <c; k++) {
                    arr[j][k]=str.charAt(k);
                }
            }
            int[][] dis=new int[r][c];
            
           //dis[i] is the minimum # of moves required to reach this place, 0 implies unvisited
           dis[0][0]=1;
           Queue<Pair> qu=new LinkedList<>();
           qu.add(new Pair(0,0));
           while(!qu.isEmpty()){
               p=qu.poll(); 
               if(arr[p.r][p.c]=='+'){
                   if(p.r>0 && dis[p.r-1][p.c]==0){
                       dis[p.r-1][p.c]=dis[p.r][p.c]+1;
                       qu.add(new Pair(p.r-1,p.c));
                   }
                   if(p.r<r-1 && dis[p.r+1][p.c]==0){
                       dis[p.r+1][p.c]=dis[p.r][p.c]+1;
                       qu.add(new Pair(p.r+1,p.c));
                   }
                   if(p.c<c-1 && dis[p.r][p.c+1]==0){
                       dis[p.r][p.c+1]=dis[p.r][p.c]+1;
                       qu.add(new Pair(p.r,p.c+1));
                   }
                   if(p.c>0 && dis[p.r][p.c-1]==0){
                       dis[p.r][p.c-1]=dis[p.r][p.c]+1;
                       qu.add(new Pair(p.r,p.c-1));
                   }
               }else if(arr[p.r][p.c]=='-'){
                  if(p.c<c-1 && dis[p.r][p.c+1]==0){
                       dis[p.r][p.c+1]=dis[p.r][p.c]+1;
                       qu.add(new Pair(p.r,p.c+1));
                   }
                   if(p.c>0 && dis[p.r][p.c-1]==0){
                       dis[p.r][p.c-1]=dis[p.r][p.c]+1;
                       qu.add(new Pair(p.r,p.c-1));
                   }
               }else if(arr[p.r][p.c]=='|'){
                   if(p.r>0 && dis[p.r-1][p.c]==0){
                       dis[p.r-1][p.c]=dis[p.r][p.c]+1;
                       qu.add(new Pair(p.r-1,p.c));
                   }
                   if(p.r<r-1 && dis[p.r+1][p.c]==0){
                       dis[p.r+1][p.c]=dis[p.r][p.c]+1;
                       qu.add(new Pair(p.r+1,p.c));
                   }
               }
           }
           if(dis[r-1][c-1]>0 && arr[r-1][c-1]!='*'){
               System.out.println(dis[r-1][c-1]);
           }else{
               System.out.println(-1);
           }
           
        }
    }
    
}
