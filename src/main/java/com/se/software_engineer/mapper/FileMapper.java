package com.se.software_engineer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.se.software_engineer.entity.File;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FileMapper extends BaseMapper<File> {
    Integer maxId();
}
