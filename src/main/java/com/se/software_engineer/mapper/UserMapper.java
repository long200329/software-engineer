package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.User;
import com.se.software_engineer.entity.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //long countByExample(UserExample example);

    //int deleteByExample(UserExample example);

    //int insert(User record);

    //int insertSelective(User record);

    //List<User> selectByExample(UserExample example);

    //int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    //int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}