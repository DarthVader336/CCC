package ccc2014sr;

import java.util.*;
public class S3 {
    public static void main(String[] args){
        Scanner reader=new Scanner(System.in);
        int tests=reader.nextInt();
        String[] results=new String[tests];
        for(int i=0;i<tests;i++){
            int len=reader.nextInt();
            int[] mountain=new int[len];
           
            for(int j=len-1;j>=0;j--){
                int car=reader.nextInt();
                mountain[j]=car;
            }//ArrayList initialization finished          
            int currentNum=1;
            int done=0;//cars in the lake
            int currentIndex=0;
            int branchremoval=0;
            ArrayList<Integer> branch=new ArrayList<>();
           
            while(true){
                
                if(mountain[currentIndex]==currentNum){
                    done++;
                    currentNum++;
                }else if(branch.size()>0 && branch.get(branch.size()-1)==currentNum){
                    done++;
                    currentNum++;
                    branch.remove(branch.size()-1);
                }else{
                    branch.add(mountain[currentIndex]);
                }
                while(branch.size()>0 && branch.get(branch.size()-1)==currentNum){
                    done++;
                    currentNum++;
                    branch.remove(branch.size()-1);
                }
                if(branch.size()+done==len && done<len){//If there are no cars in the mountain
                    if(branch.get(branch.size()-1)!=currentNum){
                        results[i]="N";
                        break;
                    }
                }
                
                
                currentIndex++;  
                if(done==len){
                    results[i]="Y";
                    break;
                }
                if(currentIndex==len){
                    results[i]="N";
                    break;
                }
            }
                
                
            
        }
        for(int h=0;h<tests;h++){
            System.out.println(results[h]);
        }
    }
        
    
    
        
}