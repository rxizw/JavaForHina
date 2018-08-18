package com.zhouwei0818;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.DecimalFormat;

public class SpaceRead {
    //统一把磁盘空间转换为G
    public static String FormatFilesSize(long files){
        DecimalFormat dt = new DecimalFormat("#.00");
        String fileSizeString = "";
        fileSizeString = dt.format((double) files/1073741824)+"G";
        return fileSizeString;
    }

    public static void driver(){
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File[] fs = File.listRoots();
        for (int i =0;i<fs.length;i++){
            System.out.println(fsv.getSystemDisplayName(fs[i]));
            System.out.println("总大小："+FormatFilesSize(fs[i].getTotalSpace()));
            System.out.println("剩余："+FormatFilesSize(fs[i].getFreeSpace()));
            System.out.println("已用："+FormatFilesSize(fs[i].getTotalSpace()-fs[i].getFreeSpace()));
        }
    }
    public static void main(String args[]){
        driver();
    }

}
