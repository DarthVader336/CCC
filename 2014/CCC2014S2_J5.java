/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        int length=reader.nextInt();
        String Nothing=reader.nextLine();
        String LineI=reader.nextLine();
        String[] arr=LineI.split(" ");
        
        String LineII=reader.nextLine();
        String[] arr2=LineII.split(" ");
        
        if(verify(arr,arr2)==true)System.out.println("good");
        else System.out.println("bad");
    }
    public static boolean verify(String[] arr1, String[] arr2){
        for(int i=0;i<arr1.length;i++){
            String name=arr1[i];
            String match=arr2[i];
            
            if(name.equals(match)){
                return false;
            }
            boolean ver=false;
            for(int j=0;j<arr1.length;j++){
                if(name.equals(arr2[j])&&ver==false&&arr1[j].equals(match)){
                    ver=true;
                }
            }
            if(ver==false)return false;
            
        }
        return true;
    }
    
}
