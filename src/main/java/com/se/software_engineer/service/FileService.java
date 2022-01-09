package com.se.software_engineer.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadFile(String primaryIndex,String secondaryIndex,String tertiaryIndex, MultipartFile file)throws IOException;
    JSONObject getFiles(String courseId);
}
