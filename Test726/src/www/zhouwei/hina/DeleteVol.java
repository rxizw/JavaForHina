package www.zhouwei.hina;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;

public class DeleteVol {
    static Logger log = Logger.getLogger(DeleteVol.class);
    public static void main(String args[]) {
        File file = new File("E:\\test");
        File filename[] = file.listFiles();
        for (int i = 0; i < filename.length; i++) {
            if (filename[i].isFile()) {
                long currenttime = System.currentTimeMillis();//获取当前时间；
                long lastModtime = filename[i].lastModified();//获取最后修改时间；
                long time = currenttime - lastModtime;
                if (time / (1000 * 3600 * 24) > 30) {
                    boolean delete = filename[i].delete();
                    if (delete) {
                        System.out.println(filename[i].getName() + "删除成功！");
                        log.info(filename[i].getName()+"删除成功！");
                    }
                }
            }
        }
    }
}
