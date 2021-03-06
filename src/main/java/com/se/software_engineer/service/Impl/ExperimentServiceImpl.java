package com.se.software_engineer.service.Impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.*;
import com.se.software_engineer.mapper.*;
import com.se.software_engineer.service.*;
import com.se.software_engineer.service.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Resource
    private ExperimentInfoMapper experimentInfoMapper;
    @Resource
    private CourseScoreMapper courseScoreMapper;
    @Resource
    private CourseScoreService courseScoreService;
    @Resource
    private ExperimentSubmissionMapper experimentSubmissionMapper;
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private ScoreService scoreService;
    @Resource
    private NoticeService noticeService;
    @Resource
    private CourseService courseService;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private UserService userService;
    @Resource
    private FileMapper fileMapper;

    public int createExperiment(ExperimentInfo experimentInfo){
        Integer num = experimentInfoMapper.maxId();
        if(num == null)
            num = 1;
        else
            num++;

        Integer exNum = experimentInfoMapper.maxNum(experimentInfo.getCourseId());
        if(exNum == null)
            exNum =1;
        else
            exNum++;
        experimentInfo.setNum(exNum);

        experimentInfo.setExperimentId(num);
        if(experimentInfoMapper.insert(experimentInfo)>0){

            courseScoreService.addExperimentScore(experimentInfo.getCourseId());

            noticeService.createNotice("教师发布实验项目:"+experimentInfo.getExperimentName(),
                    experimentInfo.getDescription(),experimentInfo.getCourseId());



            return num;
        }
        return 0;
    }

    public List getExperiments(String courseId){
        QueryWrapper<ExperimentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);

        return experimentInfoMapper.selectList(queryWrapper);
    }

    public ExperimentInfo getExperiment(String courseId,Integer experimentId){
        QueryWrapper<ExperimentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId).eq("experiment_id",experimentId);
        return experimentInfoMapper.selectOne(queryWrapper);
    }

    public int createReport(ExperimentSubmission experimentSubmission, MultipartFile file)throws IOException{

        if(file !=null ){
            experimentSubmission.setContent(uploadReport(experimentSubmission.getCourseId(),experimentSubmission.getExperimentId(),file));
        }

        QueryWrapper<ExperimentSubmission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("experiment_id",experimentSubmission.getExperimentId()).eq("course_id",experimentSubmission.getCourseId()).eq("id",experimentSubmission.getId());

        if(experimentSubmissionMapper.selectOne(queryWrapper)==null)
            return experimentSubmissionMapper.insert(experimentSubmission);
        else{
            experimentSubmission.setScore(null);
            experimentSubmission.setCorrectorName(null);
            experimentSubmission.setCorrectorId(null);
            return experimentSubmissionMapper.update(experimentSubmission,queryWrapper);
        }

    }

    public String uploadReport(String courseId,Integer ExperimentId,MultipartFile file)throws IOException {
        int num=0;
        if(file==null)return "none";

        String webPath = "http://175.24.202.178:777";
        String localPath = "C:\\software_engineer";


            num++;
            String url = webPath + "/report/" + courseId + "/" +ExperimentId+"/" +file.getOriginalFilename();
            //开始存文件
            //本地存储路径


            String path = localPath + "\\report\\" + courseId + "\\" +ExperimentId;

            FileUtils.saveUrl(file, path);

        return url;
    }

    public ExperimentSubmission getReport(String id,String courseId,int experimentId){
        QueryWrapper<ExperimentSubmission>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id).eq("course_id",courseId).eq("experiment_id",experimentId);
        return experimentSubmissionMapper.selectOne(queryWrapper);
    }

    public int putReport(String id,String courseId,int experimentId,String correctorId,String correctorName,Double reportScore){
        QueryWrapper<ExperimentSubmission>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id).eq("course_id",courseId).eq("experiment_id",experimentId);
        ExperimentSubmission report = experimentSubmissionMapper.selectOne(queryWrapper);
        report.setCorrectorId(correctorId);
        report.setCorrectorName(correctorName);

        QueryWrapper<Score> scoreQueryWrapper = new QueryWrapper<>();
        scoreQueryWrapper.eq("course_id",courseId).eq("id",id);
        Score score = scoreMapper.selectOne(scoreQueryWrapper);

        if(report.getScore()!=null){
            score.setExperimentScore(score.getExperimentScore().add(report.getScore().multiply(new BigDecimal(-1.00))));

        }
        report.setScore(new BigDecimal(reportScore));
        score.setExperimentScore(score.getExperimentScore().add(report.getScore()));
        scoreMapper.update(score,scoreQueryWrapper);

        scoreService.calculateScore(id,courseId);

        return experimentSubmissionMapper.update(report,queryWrapper);
    }

    public String getReportScore(String id,String courseId,Integer experimentId){
        QueryWrapper<ExperimentSubmission>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id).eq("course_id",courseId).eq("experiment_id",experimentId);
        ExperimentSubmission experimentSubmission = experimentSubmissionMapper.selectOne(queryWrapper);
        if(experimentSubmission !=null){
            if(experimentSubmission.getScore()!=null)
                return experimentSubmission.getScore().toString();
            else return "none";
        }

        return "null";
    }

    public JSONArray getReports(String courseId, String id){
        JSONArray array = new JSONArray();
        QueryWrapper<ExperimentInfo>experimentInfoQueryWrapper = new QueryWrapper<>();
        experimentInfoQueryWrapper.eq("course_id",courseId);
        List list = experimentInfoMapper.selectList(experimentInfoQueryWrapper);

        for(int i=0;i<list.size();i++){
            ExperimentInfo experimentInfo = (ExperimentInfo) list.get(i);
            JSONObject object = JSONUtil.parseObj(experimentInfo);
            QueryWrapper<ExperimentSubmission> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("course_id",courseId).eq("id",id).eq("experiment_id",experimentInfo.getExperimentId());
            ExperimentSubmission experimentSubmission = experimentSubmissionMapper.selectOne(queryWrapper);
            String score;
            if(experimentSubmission == null)
                score = "null";
            else if(experimentSubmission.getScore()==null)
                score = "none";
            else score = experimentSubmission.getScore().toString();
            object.put("score",score);
            array.add(object);
        }
        return array;
    }

    public JSONArray getStudentReports(String courseId,Integer experimentId){
        QueryWrapper<Permission>permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.eq("course_id",courseId);
        JSONArray array = new JSONArray();
        List permissionList = permissionMapper.selectList(permissionQueryWrapper);

        for(int i=0;i<permissionList.size();i++){
            Permission permission = (Permission) permissionList.get(i);
            if(permission.getUserPermission().equals("student")){

                JSONObject object = new JSONObject();
                QueryWrapper<ExperimentSubmission>queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("course_id",courseId).eq("id",permission.getId()).eq("experiment_id",experimentId);
                ExperimentSubmission experimentSubmission = experimentSubmissionMapper.selectOne(queryWrapper);
                object.put("id",permission.getId());
                object.put("name",userService.getUserName(permission.getId()));
                if(experimentSubmission==null) {
                    object.put("content", "null");
                    object.put("score","null");
                }
                else {
                    object.put("content", experimentSubmission.getContent());

                    if(experimentSubmission.getScore() == null)
                        object.put("score","none");
                    else
                        object.put("score",experimentSubmission.getScore().toString());
                }
                array.add(object);
            }

        }
        return array;
    }



}
