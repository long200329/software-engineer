package com.se.software_engineer.service;

import cn.hutool.json.JSONObject;
import com.se.software_engineer.entity.User;

public interface UserService {

    JSONObject login(String id, String password);
    int activate(String id,String email);
    int modifyPassword(String id,String password);
    User checkUser(String id);
    int deleteUser(String id);
    String sendMail(String id,String email);
    String getUserName(String id);
}
