import java.io.*; import java.util.*;
public class CCC20S3 {

    static int MOD=1000000007;
    static int MOD2=998244353;
    static int MOD3=1500450271;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String n=br.readLine();
        int len=n.length();
        long pow1=pow(len-1,MOD);
        long pow2=pow(len-1,MOD2);
        long pow3=pow(len-1,MOD3);
        long cha1=0; long cha2=0; long cha3=0;
        //In fact, I even hash on the number of occurrences of each letter:
                //It is #a*26^{100}+#b*26^{96}... +#z
                //Here the base is 26^4=456976
        for (int i = 0; i < len; i++) {
            cha1+=(pow(4*(122-n.charAt(i)),MOD)); cha1%=MOD;
            cha2+=(pow(4*(122-n.charAt(i)),MOD2)); cha2%=MOD2;
            cha3+=(pow(4*(122-n.charAt(i)),MOD3)); cha3%=MOD3;
        }
        String l=br.readLine(); int lel=l.length();
        if(lel<len){
            System.out.println(0);return;
        }
        long hash1=0;
        long hash2=0; long hash3=0;
        long cur1=0; long cur2=0; long cur3=0;
        for (int i = 0; i < len; i++) {
            cur1+=(pow(4*(122-l.charAt(i)),MOD)); cur1%=MOD;
            cur2+=(pow(4*(122-l.charAt(i)),MOD2)); cur2%=MOD2;
            cur3+=(pow(4*(122-l.charAt(i)),MOD3)); cur3%=MOD3;
            hash1*=26; hash1+=(l.charAt(i)-97); hash1%=MOD;
            hash2*=26; hash2+=(l.charAt(i)-97); hash2%=MOD2;
            hash3*=26; hash3+=(l.charAt(i)-97); hash3%=MOD3;
        }
        
        TreeSet<Long> has1=new TreeSet<>();
        TreeSet<Long> has2=new TreeSet<>();
        TreeSet<Long> has3=new TreeSet<>();
        int ans=0;
        for (int i = len; i <= lel; i++) {
           
            if(cur1%MOD==cha1%MOD && cur2%MOD2==cha2%MOD2 && cur3%MOD3==cha3%MOD3){
            
                if(!has1.contains(hash1) || !has2.contains(hash2) || !has3.contains(hash3)){
                    has1.add(hash1); has2.add(hash2); has3.add(hash3); ans++;
                }
            }
            if(i<lel){
                cur1-=(pow(4*(122-l.charAt(i-len)),MOD)); cur1+=(pow(4*(122-l.charAt(i)),MOD)); cur1%=MOD;
                if(cur1<0){
                    cur1+=MOD;
                }
                cur2-=(pow(4*(122-l.charAt(i-len)),MOD2)); cur2+=(pow(4*(122-l.charAt(i)),MOD2)); cur2%=MOD2;
                if(cur2<0){
                    cur2+=MOD2;
                }
                cur3-=(pow(4*(122-l.charAt(i-len)),MOD3)); cur3+=(pow(4*(122-l.charAt(i)),MOD3)); cur3%=MOD3;
                if(cur3<0){
                    cur3+=MOD3;
                }
                hash1-=pow1*(l.charAt(i-len)-97); hash1%=MOD; 
                hash1*=26; hash1+=(l.charAt(i)-97); hash1%=MOD;
                if(hash1<0){
                    hash1+=MOD;
                }
                
                hash2-=pow2*(l.charAt(i-len)-97); hash2%=MOD2; 
                hash2*=26; hash2+=(l.charAt(i)-97); hash2%=MOD2; 
                if(hash2<0){
                    hash2+=MOD2;
                }   
                hash3-=pow3*(l.charAt(i-len)-97); hash3%=MOD3; 
                hash3*=26; hash3+=(l.charAt(i)-97); hash3%=MOD3; 
                if(hash3<0){
                    hash3+=MOD3;
                }   
            }
        }
        
        System.out.println(ans);
    }
    
    public static long pow(int len, int M){
        if(len==0)return 1;
        if(len==1)return 26;
        long x=pow(len/2,M);
        return ((x*x)%M*pow(len%2,M))%M;
    }
}
