package com.example.demo.mapper;


import com.example.demo.entity.HttpJobDetailVO;
import com.example.demo.entity.HttpJobDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface HttpJobDetailsMapper {

    HttpJobDetails selectByJobNameAndJobGroup(@Param("jobName") String jobName, @Param("jobGroup") String jobGroup);

    int insertSelective(HttpJobDetails httpJobDetails);

    List<HttpJobDetailVO> selectHttpJobs(Map<String, Object> map);

    Integer selectHttpJobsCount(Map<String, Object> map);

    List<HttpJobDetailVO> selectHistoryHttpJobs(Map<String, Object> map);

    Integer selectHistoryHttpJobsCount(Map<String, Object> map);

}
