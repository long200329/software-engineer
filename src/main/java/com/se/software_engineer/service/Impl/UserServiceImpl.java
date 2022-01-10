package com.se.software_engineer.service.Impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.User;
import com.se.software_engineer.mapper.UserMapper;
import com.se.software_engineer.service.UserService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private JavaMailSender mailSender;

    @Resource
    private UserMapper userMapper;

    @Override
    public JSONObject login(String id, String password) {
        List list = this.userMapper.selectByMap(new HashMap() {
            {
                this.put("id", id);
                this.put("password", password);
            }
        });
        if(list.size()!=0)
            return JSONUtil.parseObj(list.get(0));
        else
            return null;
    }
    @Override
    public int activate(String id,String email){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User user = userMapper.selectOne(queryWrapper);
        user.setState("active");
        return userMapper.update(user,queryWrapper);
    }
    @Override
    public int modifyPassword(String id,String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User user = userMapper.selectOne(queryWrapper);
        user.setPassword(password);
        return userMapper.update(user,queryWrapper);
    }
    @Override
    public User checkUser(String id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }
    @Override
    public int deleteUser(String id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return userMapper.delete(queryWrapper);
    }

    @Override
    public String sendMail(String id,String email){
        String captcha = RandomUtil.randomStringUpper(8);
        //发送邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tongjsoftware@163.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("教学实验系统验证码");
        simpleMailMessage.setText(captcha);
        mailSender.send(simpleMailMessage);
        return captcha;
    }

    @Override
    public String getUserName(String id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User user = userMapper.selectOne(queryWrapper);
        return user.getName();
    }

    @Override
    public List getAllUser(){
        QueryWrapper<User>queryWrapper = new QueryWrapper<>();
        return userMapper.selectList(queryWrapper);
    }



}
