import java.io.*; import java.util.*;
public class CCC03S3 {
    public static class Pair{
        int r; int c;
        public Pair(int a, int b){
            this.r=a; this.c=b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cnt=Integer.parseInt(br.readLine()); Pair p;
        int r=Integer.parseInt(br.readLine());
        int c=Integer.parseInt(br.readLine());
        //Flood fill
        char[][] arr=new char[r][c];
        for (int i = 0; i < r; i++) {
            String str=br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j]=str.charAt(j);
            }
        }
        int[][] color=new int[r][c];
        int cur=1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(color[i][j]==0 && arr[i][j]=='.') {
                    color[i][j]=cur;
                    Queue<Pair> qu=new LinkedList<>();
                    qu.add(new Pair(i,j));
                    while(!qu.isEmpty()){
                        p=qu.poll();
                        if(p.r>0 && color[p.r-1][p.c]==0 && arr[p.r-1][p.c]=='.'){
                            color[p.r-1][p.c]=cur;
                            qu.add(new Pair(p.r-1,p.c));
                        }
                        if(p.r<r-1 && color[p.r+1][p.c]==0 && arr[p.r+1][p.c]=='.'){
                            color[p.r+1][p.c]=cur;
                            qu.add(new Pair(p.r+1,p.c));
                        }
                        if(p.c>0 && color[p.r][p.c-1]==0 && arr[p.r][p.c-1]=='.'){
                            color[p.r][p.c-1]=cur;
                            qu.add(new Pair(p.r,p.c-1));
                        }
                        if(p.c<c-1 && color[p.r][p.c+1]==0 && arr[p.r][p.c+1]=='.'){
                            color[p.r][p.c+1]=cur;
                            qu.add(new Pair(p.r,p.c+1));
                        }
                    }
                    cur++;
                }
            }
        }
        
        int[] size=new int[cur-1];
        for (int i = 0; i < r;i++) {
              for (int j = 0; j < c; j++) {
                if(color[i][j]>0){
                    size[color[i][j]-1]++;
                }
            }
        }
        
        Arrays.sort(size);
        //System.out.println(Arrays.toString(size));
        int x=cur-2;
        while(x>=0 && cnt>=size[x]){
            cnt-=size[x]; x--;
        }
        if(cur-2-x!=1){
            System.out.println((cur-2-x)+" rooms, "+cnt+" square metre(s) left over");
        }else{
            System.out.println(1+" room, "+cnt+" square metre(s) left over");
        }
    }
    
}
