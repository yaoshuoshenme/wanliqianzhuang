package com.qzwl.common.util;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FDFSUtil {
    private TrackerClient trackerClient;
    private TrackerServer trackerServer;
    private StorageClient storageClient;
    private StorageServer storageServer;

    public FDFSUtil(String conf) throws IOException, MyException {
        if(conf.startsWith("classpath")){
            conf = conf.replace("classpath:",getClass().getResource("/").getPath());
        }

        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageClient = new StorageClient1(trackerServer,storageServer);
    }

    //上传文件，参数时文件路径,后缀,元数据（文件描述）
    public String[] upload_file(String fileName, String ext_name, NameValuePair[] pairs) throws Exception {
        return storageClient.upload_file(fileName, ext_name, pairs);
    }

    public String[] upload_file(String fileName)  throws Exception{
        return upload_file(fileName, null, null);
    }


    public String[] upload_file(String fileName,String ext_name)  throws Exception{
        return upload_file(fileName, ext_name, null);
    }

    public String[] upload_file(String fileName,NameValuePair[] pairs)  throws Exception{
        return upload_file(fileName, null, pairs);
    }
    /**
     上传二进制数据,需要将文件先转换为二进制
     */
    public String[] upload_file(byte[]source,String ext_name,NameValuePair[] pairs) throws Exception{
        return storageClient.upload_file(source, ext_name, pairs);
    }

}
