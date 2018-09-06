
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DeleteDemo {
        public static void main(String[] args)  {
            File f = new File("D:\\apache-maven-3.5.0-bin\\apache-maven-3.5.0\\repository");
            deleteFile(f);
        }
        public static void deleteFile(File file) {
            boolean res = false;
            // 判断传递进来的是文件还是文件夹,如果是文件,直接删除,如果是文件夹,则判断文件夹里面有没有东西
            if (file.isDirectory()) {
                // 如果是目录,就删除目录下所有的文件和文件夹
                File[] files = file.listFiles();
                // 遍历目录下的文件和文件夹
                for (File f : files) {
                    // 如果是文件,就删除
                    if (f.isFile() && f.getName().contains("m2e-lastUpdated.properties")) {
                        System.out.println("已经被删除的文件:" + f);
                        res = true;
                        break;
                        // 删除文件
//                        f.delete();
                    }
                }

                if(res){
                    try {
                        FileUtils.deleteDirectory(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                    System.out.println("删除的文件夹+" + file.getName());
                }else{
                    for(File f: files){
                        deleteFile(f);
                    }
                }

                // 删除文件夹自己,如果它低下是空的,就会被删除
                return;// 文件夹被删除后,直接用return语句结束当次递归调用
            }
            // 如果是文件,就直接删除自己
//            System.out.println("已经被删除的文件----------->:" + file);
//            file.delete();
        }
    }

