package com.se.software_engineer.Controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.se.software_engineer.entity.CommonResult;
import com.se.software_engineer.service.FeedbackService;
import com.se.software_engineer.service.FileService;
import com.se.software_engineer.service.NoticeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

@RestController
@CrossOrigin("*")
public class teachAidController {

    @Resource
    private NoticeService noticeService;

    @Resource
    private FeedbackService feedbackService;

    @Resource
    private FileService fileService;

    @PostMapping("/notice")
    public CommonResult createNotice(@RequestParam String noticeTittle,@RequestParam String noticeContent,@RequestParam String courseId){
        if(courseId ==null)
            return CommonResult.failure("缺少课程id");

        if(noticeService.createNotice(noticeTittle,noticeContent,courseId)>0){
            return CommonResult.success("创建通知成功",null);
        }
        return CommonResult.failure("创建通知失败");
    }

    @GetMapping("/notice")
    public CommonResult getNotices(@RequestParam String courseId){
        if(courseId==null)
            return CommonResult.failure("错误，缺少课程id");
        return CommonResult.success("查询成功",noticeService.getNotices(courseId));
    }

    @PostMapping("/feedback")
    public CommonResult createFeedback(@RequestParam String feedbackContent,@RequestParam String courseId,@RequestParam String id){
        if(courseId==null)
            return CommonResult.failure("错误，缺少课程id");
        if(id==null)
            return CommonResult.failure("错误，缺少id");
        if(feedbackContent==null)
            return CommonResult.failure("错误，缺少反馈内容");

        if(feedbackService.createFeedback(id,courseId,feedbackContent)>0)
            return CommonResult.success("反馈成功",null);
        return CommonResult.failure("反馈失败");
    }

    @GetMapping("/feedback/course")
    public CommonResult getCourseFeedbacks(@RequestParam String courseId){
        if(courseId==null)
            return CommonResult.failure("错误，缺少课程id");

        return CommonResult.success("查询成功",feedbackService.getCourseFeedbacks(courseId));
    }

    @GetMapping("/feedback/student")
    public CommonResult getStudentFeedbacks(@RequestParam String courseId,@RequestParam String id){
        if(courseId==null)
            return CommonResult.failure("错误，缺少课程id");
        if(id==null)
            return CommonResult.failure("错误，缺少id");

        return CommonResult.success("查询成功",feedbackService.getStudentFeedbacks(courseId,id));
    }
    @GetMapping("/notice/user")
    public CommonResult getStudentFeedbacks(@RequestParam String id){

        if(id==null)
            return CommonResult.failure("错误，缺少id");

        JSONArray array = noticeService.getUserNotices(id);
        array.sort(Comparator.comparing(obj -> ((JSONObject) obj).getInt("noticeId")));
        Collections.reverse(array);
        return CommonResult.success("查询成功",array);
    }

    @PostMapping("/file")
    public CommonResult uploadFile(@RequestParam String primaryIndex,@RequestParam(required = false) String secondaryIndex,@RequestParam(required = false) String tertiaryIndex,@RequestPart MultipartFile file)throws IOException{

        return CommonResult.success("上传成功",fileService.uploadFile(primaryIndex,secondaryIndex,tertiaryIndex,file));
    }

    @GetMapping("/file")
    public CommonResult getFile(@RequestParam String courseId){
        return CommonResult.success("查询成功",fileService.getFiles(courseId));
    }

}
