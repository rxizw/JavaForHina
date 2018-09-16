package com.zhouwei818;

public class splite {
    public static void main(String args[]){
        String str = "chrome.exe                   23028 Console                    8     22,012 K";
        String strArray[] = str.split("\\s+");
        for(int i =0;i<strArray.length;i++){
            if(i == 0||i==4){
                System.out.println(strArray[i]);
            }
        }
        System.out.println();
    }
}
