package com.xs.cloud.common.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface UserMapper {
    List<Map> testCity();

}
