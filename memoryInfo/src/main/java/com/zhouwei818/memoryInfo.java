package com.zhouwei818;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class memoryInfo {
    public static void main(String args[]) {
        String command = "tasklist";
        Runtime runtime = Runtime.getRuntime();
        String line = null;
        try {
            Process process = runtime.exec(command);
            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            File info = new File("info.txt");
            PrintStream ps = new PrintStream(info);
            while ((line = bf.readLine()) != null) {
                byte[] bs = line.getBytes("UTF-8");
                line = new String(bs, "UTF-8");
                System.out.println(line);
                ps.print(line);
                ps.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取文本内容，并找到我需要的进程详细信息
        List<String> strs = new ArrayList<String>();
        String pattern = ".*rome.*";
        File file1 = new File("info.txt");
        getInfo(strs,pattern);

        //把文件保存在文件夹myInfo中
        for(int i = 0;i<strs.size();i++){
            String line2 = strs.get(i);
            File file2 = new File("myInfo.txt");
            try {
                FileOutputStream fos2 = new FileOutputStream(file2);
                PrintStream ps2 = new PrintStream(fos2);
                ps2.println(line2);
                ps2.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

//匹配出索要查询的信息，并保存到List中。
    private static void getInfo(List<String> strs,String pattern) {
        File file1 = new File("info.txt");
        if (file1.isFile() && file1.exists()) {
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file1));
                BufferedReader bufferedReader = new BufferedReader(read);
                String line1 = null;
                while ((line1 = bufferedReader.readLine()) != null) {
                    //通过正则表达式获取内容
                    getMatch(strs,line1,pattern);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
private static void getMatch(List<String> strs, String lineTxt,String pattern) {
    //Pattern p = Pattern.compile(".*WeChat.exe.*");
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(lineTxt);
    boolean result = m.find();
    String find_result = null;
    if (result)
    {
        find_result = m.group(0);
        strs.add(find_result);
    }
}
}

