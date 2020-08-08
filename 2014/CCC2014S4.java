import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class CCC2014S4 {
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()); 
        int T=Integer.parseInt(br.readLine());
        int[] xx=new int[2*N];
        int[] yy=new int[2*N];
        int[][] arr=new int[N][5];
        long res=0;//resulting area that >=T
        String[] t; int l; int r; int u; int d; int v;
        for(int i=0;i<N;i++){
            t=br.readLine().split("\\ ");
            for (int j = 0; j < 5; j++) {
                arr[i][j]=Integer.parseInt(t[j]);
            }
            
            xx[2*i]=arr[i][0];
            xx[2*i+1]=arr[i][2];
            yy[2*i]=arr[i][1];
            yy[2*i+1]=arr[i][3];
        }
        Arrays.sort(xx); Arrays.sort(yy);
        xx=cleardup(xx); yy=cleardup(yy);
        HashMap<Integer,Integer> xtoi=new HashMap<>();
        ArrayList<Integer> arl;
        for (int i = 0; i < xx.length; i++) {
                xtoi.put(xx[i],i);
        }
        HashMap<Integer,Integer> ytoi=new HashMap<>();
        for (int i = 0; i < yy.length; i++) {
                ytoi.put(yy[i],i);
        }
        
        int[][] diff=new int[yy.length-1][xx.length-1];
        for (int i = 0; i < N; i++) {
            
            int le=xtoi.get(arr[i][0]);
            int ri=xtoi.get(arr[i][2]);
            int uu=ytoi.get(arr[i][1]);
            int dd=ytoi.get(arr[i][3]);
            
            for(int j=uu;j<dd;j++){
                diff[j][le]+=arr[i][4];
                if(ri<xx.length-1){diff[j][ri]-=arr[i][4];}
            }
        }
        
        int cur=0;
        
        for (int i = 0; i < yy.length-1; i++) {
            cur=0;
            for (int j = 0; j < xx.length-1; j++) {
                cur+=diff[i][j];
                if(cur>=T){
                    
                    res+=(long)((long)(xx[j+1]-xx[j]))*((long)(yy[i+1]-yy[i]));
                    
                    
                   
                }
            }
        }
        System.out.println(res);
    }
    public static int[] cleardup(int[] arr){
        //arr is sorted
        int ele=0;
        for (int i = 0; i < arr.length; i++) {
            if(i==0 || arr[i-1]<arr[i]){
                ele++;
            }
        }
        int[] res=new int[ele]; int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(i==0 || arr[i-1]<arr[i]){
                res[count]=arr[i];
                count++;
            }
        }
        return res;
    }
}

