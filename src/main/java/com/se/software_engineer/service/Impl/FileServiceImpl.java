package com.se.software_engineer.service.Impl;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.File;
import com.se.software_engineer.mapper.FileMapper;
import com.se.software_engineer.service.ExperimentService;
import com.se.software_engineer.service.FileService;
import com.se.software_engineer.service.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Resource
    private FileMapper fileMapper;
    @Resource
    private ExperimentService experimentService;

    public String uploadFile(String primaryIndex,String secondaryIndex,String tertiaryIndex, MultipartFile file)throws IOException {

        if(file==null)return "none";

        String webPath = "http://175.24.202.178:777";
        String localPath = "C:\\software_engineer";

        File file1 = new File();
        Integer num = fileMapper.maxId();
        if(num == null)
            num = 1;
        else num++;
        file1.setFileId(num);
        file1.setFileName(file.getOriginalFilename());
        file1.setPrimaryIndex(primaryIndex);
        file1.setSecondaryIndex(secondaryIndex);
        file1.setTertiaryIndex(tertiaryIndex);

        num++;
        String url = webPath + "/resource/" + primaryIndex + "/" +secondaryIndex+"/" +tertiaryIndex+"/" +file.getOriginalFilename();
        //开始存文件
        //本地存储路径
        file1.setUrl(url);

        fileMapper.insert(file1);

        String path = localPath + "\\resource\\" + primaryIndex + "\\" +secondaryIndex+ "\\" +tertiaryIndex;

        FileUtils.saveUrl(file, path);

        return url;
    }

    public JSONObject getFiles(String courseId) {
        QueryWrapper<File> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("primary_index", courseId);
        List list = fileMapper.selectList(queryWrapper);
        JSONObject objects = new JSONObject();

        for (int i = 0; i < list.size(); i++) {

            //JSONObject object = JSON.parseObject(((File)list.get(i)).toString());
            JSONObject object = JSON.parseObject(toJson((File)list.get(i)));
            String primaryIndex = (String) object.get("primaryIndex");
            String secondaryIndex = (String) object.get("secondaryIndex");
            String tertiaryIndex = (String) object.get("tertiaryIndex");

            if (tertiaryIndex != null) {

                if(!objects.containsKey(secondaryIndex)) {
                    JSONObject temp = new JSONObject();
                    JSONArray array = new JSONArray();
                    JSONObject object1 = new JSONObject();
                    array.add(object);
                    temp.put("files", array);
                    object1.put(tertiaryIndex, temp);
                    objects.put(secondaryIndex, object1);
                }
                else if (!objects.getJSONObject(secondaryIndex).containsKey(tertiaryIndex)) {
                    JSONObject temp = new JSONObject();
                    JSONArray array = new JSONArray();
                    array.add(object);
                    temp.put("files", array);
                    objects.getJSONObject(secondaryIndex).put(tertiaryIndex, temp);
                }
                else if (objects.getJSONObject(secondaryIndex).containsKey(tertiaryIndex)) {

                    if (!objects.getJSONObject(secondaryIndex).getJSONObject(tertiaryIndex).containsKey("files"))
                        objects.getJSONObject(secondaryIndex).getJSONObject(tertiaryIndex).put("files", new JSONArray());

                    objects.getJSONObject(secondaryIndex).getJSONObject(tertiaryIndex).getJSONArray("files").add(object);
                }


            }
            else if (secondaryIndex != null) {

                if(!objects.containsKey(secondaryIndex)) {
                    JSONObject object1 = new JSONObject();
                    JSONArray array = new JSONArray();
                    array.add(object);
                    object1.put("files", array);
                    objects.put(secondaryIndex, object1);
                }
                else {
                    if (!objects.getJSONObject(secondaryIndex).containsKey("files"))
                        objects.getJSONObject(secondaryIndex).put("files", new JSONArray());

                    objects.getJSONObject(secondaryIndex).getJSONArray("files").add(object);
                }


            }
            else {
                if (objects.containsKey("files"))
                    objects.put("files", new JSONArray());
                objects.getJSONArray("files").add(object);

            }


        }
        return objects;
    }
    public String toJson(File file){
        String s = JSONUtil.parseObj(file).toString();
        return s;
    }




}
