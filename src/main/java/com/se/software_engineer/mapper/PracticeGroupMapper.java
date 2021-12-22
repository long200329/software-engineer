package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.PracticeGroupExample;
import com.se.software_engineer.entity.PracticeGroup;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface PracticeGroupMapper extends BaseMapper<PracticeGroup>{

}