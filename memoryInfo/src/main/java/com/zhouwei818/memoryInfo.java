package com.zhouwei818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class memoryInfo {
    public static void main(String args[]){
        String command = "tasklist";
        Runtime runtime = Runtime.getRuntime();
        String line = null;
        try {
            Process process = runtime.exec(command);
            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));
            while ((line=bf.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
