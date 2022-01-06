package com.se.software_engineer.service.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
public class FileUtils {
    /**
     * ip地址
     */
    private static final String ip = "175.24.202.178";
    /**
     * 开放端口号
     */
    private static final String host = "777";
    public static void saveUrl(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(path);
        //创建文件夹
        file.mkdirs();
        //存储文件
        String _path=path+"\\"+multipartFile.getOriginalFilename();
        log.info("存储文件："+_path);
        multipartFile.transferTo(new File(_path));

        //String[] pics = path.split("C:/upload/");
        //return ip+":"+host+"/"+pics[1]+multipartFile.getOriginalFilename();
    }
}
