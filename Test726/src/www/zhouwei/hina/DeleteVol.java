package www.zhouwei.hina;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.dtools.ini.*;

public class DeleteVol {
    static Logger log = Logger.getLogger(DeleteVol.class);
    public static void main(String args[]) {
        IniFile iniFile = new BasicIniFile();
        File iniLocal = new File("C:\\config.ini");
        IniFileReader rad = new IniFileReader(iniFile,iniLocal);
        try {
            rad.read();
            IniSection iniSection = iniFile.getSection("section");
            IniItem iDay = iniSection.getItem("day");
            int day1 = Integer.parseInt(iDay.getValue());
            IniItem iFile = iniSection.getItem("file");
            String file1 = iFile.getValue();
            System.out.println(day1);
            System.out.println(file1);
            File file = new File(file1);
            File filename[] = file.listFiles();
            for (int i = 0; i < filename.length; i++) {
                if (filename[i].isFile()) {
                    long currenttime = System.currentTimeMillis();//获取当前时间；
                    long lastModtime = filename[i].lastModified();//获取最后修改时间；
                    long time = currenttime - lastModtime;
                    if (time / (1000 * 3600 * 24) > day1) {
                        boolean delete = filename[i].delete();
                        if (delete) {
                            System.out.println(filename[i].getName() + "删除成功！");
                            log.info(filename[i].getName()+"删除成功！");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
