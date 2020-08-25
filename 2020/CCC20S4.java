
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CCC20S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int N=str.length();
        int[] A=new int[N+1]; int[] B=new int[N+1]; int[] C=new int[N+1];
        //Prefix
        for (int i = 0; i < N; i++) {
            if(str.charAt(i)=='A'){
                A[i+1]=A[i]+1; B[i+1]=B[i]; C[i+1]=C[i];
            }else if(str.charAt(i)=='B'){
                A[i+1]=A[i]; B[i+1]=B[i]+1; C[i+1]=C[i];
            }else{
                A[i+1]=A[i]; B[i+1]=B[i]; C[i+1]=C[i]+1;
            }
        }
        int x=N; int a=A[N]; int b=B[N]; int c=C[N];
        int AB=0; int AC=0; int BC=0; int BA=0; int CA=0; int CB=0;
        //Case 1: ABC
        int cur;
        for (int i = b+c; i < N; i++) {
            cur=0; AB=0; AC=0;BC=0; BA=0; CA=0; CB=0;
            //First do [i,i+a)
            CA+=(C[N]-C[i]);
            CA+=C[i+a-N];
            BA+=(B[N]-B[i]);
            BA+=B[i+a-N];
            //Now do [i+a-N, i+a+b-N) (B's)
            AB+=(A[i+a+b-N]-A[i+a-N]);
            CB+=(C[i+a+b-N]-C[i+a-N]);
            //Now do [i+a+b-N, i-1]
            AC+=(A[i]-A[i+a+b-N]);
            BC+=(B[i]-B[i+a+b-N]);
            
            if(AB<=BA){
                cur+=AB; BA-=AB; AB=0; 
            }else{
                cur+=BA; AB-=BA; BA=0; 
            }
            if(CB<=BC){
                cur+=CB; BC-=CB; CB=0; 
            }else{
                cur+=BC; CB-=BC; BC=0; 
            }
            if(AC<=CA){
                cur+=AC; CA-=AC; AC=0; 
            }else{
                cur+=CA; AC-=CA; CA=0; 
            }
            if(AB>0){//Now, AB=BC=CA
                cur+=2*AB;
            }else{
                cur+=2*AC;
            }
            x=Math.min(x,cur);
            //System.out.println(cur);
        }
        for (int i = c; i < b+c; i++) {
            cur=0; AB=0; AC=0;BC=0; BA=0; CA=0; CB=0;
            //First do [i,i+a)
            CA+=(C[i+a]-C[i]);
            BA+=(B[i+a]-B[i]);
            
            //Now do [i+a, N) then [0, i+a+b) (B's, crossover)
            AB+=(A[N]-A[i+a]);
            AB+=A[i+a+b-N];
            CB+=(C[N]-C[i+a]);
            CB+=C[i+a+b-N];
            //Now do [i+a+b-N, i-1]
            
            AC+=(A[i]-A[i+a+b-N]);
            BC+=(B[i]-B[i+a+b-N]);
            
            if(AB<=BA){
                cur+=AB; BA-=AB; AB=0; 
            }else{
                cur+=BA; AB-=BA; BA=0; 
            }
            if(CB<=BC){
                cur+=CB; BC-=CB; CB=0; 
            }else{
                cur+=BC; CB-=BC; BC=0; 
            }
            if(AC<=CA){
                cur+=AC; CA-=AC; AC=0; 
            }else{
                cur+=CA; AC-=CA; CA=0; 
            }
            if(AB>0){//Now, AB=BC=CA
                cur+=2*AB;
            }else{
                cur+=2*AC;
            }
            x=Math.min(x,cur);
            //System.out.println(cur);
        }
        for (int i = 0; i < c; i++) {
            AB=0; AC=0;BC=0; BA=0; CA=0; CB=0;
            //First do [i,i+a)
            CA+=(C[i+a]-C[i]);
            BA+=(B[i+a]-B[i]);
            //Now do [i+a,i+a+b)
            AB+=(A[i+a+b]-A[i+a]);
            CB+=(C[i+a+b]-C[i+a]);
            //Now [i+a+b, crossover)
            AC+=(A[N]-A[i+a+b]);
            AC+=(A[i]);
            BC+=(B[N]-B[i+a+b]);
            BC+=(B[i]);
            cur=0;
            
            if(AB<=BA){
                cur+=AB; BA-=AB; AB=0; 
            }else{
                cur+=BA; AB-=BA; BA=0; 
            }
            if(CB<=BC){
                cur+=CB; BC-=CB; CB=0; 
            }else{
                cur+=BC; CB-=BC; BC=0; 
            }
            if(AC<=CA){
                cur+=AC; CA-=AC; AC=0; 
            }else{
                cur+=CA; AC-=CA; CA=0; 
            }
            if(AB>0){//Now, AB=BC=CA
                cur+=2*AB;
            }else{
                cur+=2*AC;
            }
            x=Math.min(x,cur);
            //System.out.println(cur);
        }
        for (int i = b+c; i < N; i++) {
            cur=0;  AB=0; AC=0;BC=0; BA=0; CA=0; CB=0;
            //First do [i,i+a)
            CA+=(C[N]-C[i]);
            CA+=C[i+a-N];
            BA+=(B[N]-B[i]);
            BA+=B[i+a-N];
            //Now do [i+a-N, i+a+b-N) (B's)
            AC+=(A[i+a+c-N]-A[i+a-N]);
            BC+=(B[i+a+c-N]-B[i+a-N]);
            //Now do [i+a+b-N, i-1]
            AB+=(A[i]-A[i+a+c-N]);
            CB+=(C[i]-C[i+a+c-N]);
            
            if(AB<=BA){
                cur+=AB; BA-=AB; AB=0; 
            }else{
                cur+=BA; AB-=BA; BA=0; 
            }
            if(CB<=BC){
                cur+=CB; BC-=CB; CB=0; 
            }else{
                cur+=BC; CB-=BC; BC=0; 
            }
            if(AC<=CA){
                cur+=AC; CA-=AC; AC=0; 
            }else{
                cur+=CA; AC-=CA; CA=0; 
            }
            if(AB>0){//Now, AB=BC=CA
                cur+=2*AB;
            }else{
                cur+=2*AC;
            }
            x=Math.min(x,cur);
            //System.out.println(cur);
        }
        for (int i = b; i < b+c; i++) {
            cur=0; AB=0; AC=0;BC=0; BA=0; CA=0; CB=0;
            //First do [i,i+a)
            CA+=(C[i+a]-C[i]);
            BA+=(B[i+a]-B[i]);
            
            //Now do [i+a, N) then [0, i+a+b) (B's, crossover)
            AC+=(A[N]-A[i+a]);
            AC+=A[i+a+c-N];
            BC+=(B[N]-B[i+a]);
            BC+=B[i+a+c-N];
            //Now do [i+a+b-N, i-1]
            AB+=(A[i]-A[i+a+c-N]);
            CB+=(C[i]-C[i+a+c-N]);
            
            if(AB<=BA){
                cur+=AB; BA-=AB; AB=0; 
            }else{
                cur+=BA; AB-=BA; BA=0; 
            }
            if(CB<=BC){
                cur+=CB; BC-=CB; CB=0; 
            }else{
                cur+=BC; CB-=BC; BC=0; 
            }
            if(AC<=CA){
                cur+=AC; CA-=AC; AC=0; 
            }else{
                cur+=CA; AC-=CA; CA=0; 
            }
            if(AB>0){//Now, AB=BC=CA
                cur+=2*AB;
            }else{
                cur+=2*AC;
            }
            x=Math.min(x,cur);
            //System.out.println(cur);
        }
        for (int i = 0; i < b; i++) {
             AB=0; AC=0;BC=0; BA=0; CA=0; CB=0;
            //First do [i,i+a)
            CA+=(C[i+a]-C[i]);
            BA+=(B[i+a]-B[i]);
            //Now do [i+a,i+a+b)
            AC+=(A[i+a+c]-A[i+a]);
            BC+=(B[i+a+c]-B[i+a]);
            //Now [i+a+b, crossover)
            AB+=(A[N]-A[i+a+c]);
            AB+=(A[i]);
            CB+=(C[N]-C[i+a+c]);
            CB+=(C[i]);
            cur=0;
            if(AB<=BA){
                cur+=AB; BA-=AB; AB=0; 
            }else{
                cur+=BA; AB-=BA; BA=0; 
            }
            if(CB<=BC){
                cur+=CB; BC-=CB; CB=0; 
            }else{
                cur+=BC; CB-=BC; BC=0; 
            }
            if(AC<=CA){
                cur+=AC; CA-=AC; AC=0; 
            }else{
                cur+=CA; AC-=CA; CA=0; 
            }
            if(AB>0){//Now, AB=BC=CA
                cur+=2*AB;
            }else{
                cur+=2*AC;
            }
            x=Math.min(x,cur);
            //System.out.println(cur);
        }
        System.out.println(x);
    }
    
}
