package com.tcsoft.sample.utils;


import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.FtpConfig;
import cn.hutool.extra.ftp.FtpMode;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author WMY
 */
public class FtpUtil {

    //ftp服务器地址
    @Value("${ftp.host}")
    private String hostname;

    //ftp服务器端口
    @Value("${ftp.port}")
    private int port;

    //ftp登录账号
    @Value("${ftp.username}")
    private String username;

    //ftp登录密码
    @Value("${ftp.password}")
    private String password;

    //ftp保存目录
    @Value("${ftp.savePath}")
    private String savePath;

//    ftp配置类
    private FtpConfig ftpConfig;
//    ftp模式
    private FtpMode ftpMode;
//    ftp实体类
    private Ftp ftp;

    public FtpUtil() {
//        createFtpConfig();
        createFtpMode();
        createFtp();
    }

//    private void createFtpConfig(){
//        ftpConfig = new FtpConfig(hostname, port, username, password, StandardCharsets.UTF_8);
//    }

    private void createFtpMode(){
        ftpMode = FtpMode.Passive;
    }

    private void createFtp(){
        ftp = new Ftp("192.168.3.3", 2121, "EQAPBox", "EQAPBox", StandardCharsets.UTF_8, ftpMode);
    }

    public List<String> getAllFiles(){
        return ftp.ls(savePath);
    }

    public void download(String path, File outFile){
        ftp.download(path, outFile);
    }

    public static void main(String[] args) {
        FtpUtil ftpUtil = new FtpUtil();
        List<String> allFiles = ftpUtil.getAllFiles();
        String basePath = "D:\\data\\";
        File outFile = new File("D:\\data-copy");
        allFiles.forEach(x -> {
            String filePath = basePath + x;
            ftpUtil.download(filePath, outFile);
        });
    }

}
