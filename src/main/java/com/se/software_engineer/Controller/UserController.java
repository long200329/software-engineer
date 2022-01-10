package com.se.software_engineer.Controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.se.software_engineer.entity.CommonResult;
import com.se.software_engineer.entity.User;
import com.se.software_engineer.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/login")
    public CommonResult login(@RequestParam String id,@RequestParam String password){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        if(password == null)
            return CommonResult.failure("错误，缺少密码");

        JSONObject object = userService.login(id,password);
        if(object != null){
            StpUtil.login(id);
            object.put("token",StpUtil.getTokenInfo().getTokenValue());
            return CommonResult.success("登陆成功", object);
        }
        return CommonResult.failure("登陆失败");
    }

    @GetMapping("/user/checkLogin")
    public CommonResult checkLogin(@RequestParam String id){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        if(!StpUtil.isLogin())
            return CommonResult.failure("未登录");
        return CommonResult.success("请求成功，已登录",null);
    }

    @GetMapping("/user/getToken")
    public CommonResult getToken(){
        return CommonResult.success("请求成功",StpUtil.getLoginIdAsString());
    }

    @GetMapping("/user/logout")
    public CommonResult logout(@RequestParam String id){
        StpUtil.logout(id);
        return CommonResult.success("用户已退出登录",null);
    }

    @PutMapping("/user/password")
    public CommonResult modifyPassword(@RequestParam String id,@RequestParam String password){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        if(password == null)
            return CommonResult.failure("错误，缺少password");

        if(userService.modifyPassword(id,password)>0){
            return CommonResult.success("修改成功",null);
        }
        return CommonResult.failure("修改失败");
    }

    @PutMapping("/user/activate")
    public CommonResult activate(@RequestParam String id,@RequestParam String email){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        if(userService.activate(id,email)>0){
            return CommonResult.success("激活成功",null);
        }
        return CommonResult.failure("激活失败");
    }

    @GetMapping("/user")
    public CommonResult getUser(@RequestParam String id){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        User user = userService.checkUser(id);
        if(user != null){
            return CommonResult.success("查询成功",user);
        }
        return CommonResult.failure("查询失败");
    }

    @DeleteMapping("/user")
    public CommonResult deleteUser(@RequestParam String id){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        if(userService.deleteUser(id)>0)
            return CommonResult.success("删除成功",null);
        return CommonResult.failure("删除失败");
    }

    @PostMapping("/user/email")
    public CommonResult sendMail(@RequestParam String id,@RequestParam String email){
        if(email == null)
            return CommonResult.failure("email为空");
        return CommonResult.success("发送成功",userService.sendMail(id,email));
    }

    @GetMapping("/user/all")
    public CommonResult getAllUser(){
        List list = userService.getAllUser();
        List array = new JSONArray();
        for(int i=0;i<list.size();i++){
            User user = (User)list.get(i);
            if(!user.getIdentification().equals("admin"))
                array.add(user);
        }
        return CommonResult.success("查询成功",array);
    }

}
