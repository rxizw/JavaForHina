package com.zhouwei0818;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.SheetRange;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class SpaceRead {
    //统一把磁盘空间转换为G
    public static String FormatFilesSize(long files){
        DecimalFormat dt = new DecimalFormat("#.00");
        String fileSizeString = "";
        fileSizeString = dt.format((double) files/1073741824)+"G";
        return fileSizeString;
    }

    public static void driver() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File[] fs = File.listRoots();
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Sheet1");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("盘符");
        row.createCell(1).setCellValue("总大小");
        row.createCell(2).setCellValue("剩余");
        row.createCell(3).setCellValue("可用");
        for (int i = 0; i < fs.length; i++) {
                row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(fsv.getSystemDisplayName(fs[i]));
                row.createCell(1).setCellValue(FormatFilesSize(fs[i].getTotalSpace()));
                row.createCell(2).setCellValue(FormatFilesSize(fs[i].getFreeSpace()));
                row.createCell(3).setCellValue(FormatFilesSize(fs[i].getTotalSpace()-fs[i].getFreeSpace()));
                System.out.println(fsv.getSystemDisplayName(fs[i]));
                System.out.println("总大小：" + FormatFilesSize(fs[i].getTotalSpace()));
                System.out.println("剩余：" + FormatFilesSize(fs[i].getFreeSpace()));
                System.out.println("已用：" + FormatFilesSize(fs[i].getTotalSpace() - fs[i].getFreeSpace()));
        }
        try {
            FileOutputStream fout = new FileOutputStream("Space.xls");
            try {
                wb.write(fout);
                fout.close();
                System.out.println("导出成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        driver();
    }

}
