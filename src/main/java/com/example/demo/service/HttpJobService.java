package com.example.demo.service;

import com.example.demo.entity.HttpJobLogs;
import com.example.demo.entity.Page;
import com.example.demo.param.AddHttpJobParam;
import com.example.demo.entity.HttpJobDetailVO;

/**
 * Http类型任务Service
 *
 * @author hellofly
 * @date 2019/4/9
 */
public interface HttpJobService {

    /**
     * 添加http类型job
     *
     * @param addHttpJobParam
     */
    void addHttpJob(AddHttpJobParam addHttpJobParam);

    /**
     * 查看正在进行的http类型job
     *
     * @param searchParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<HttpJobDetailVO> getHttpJobs(String searchParam, Integer pageSize, Integer pageNum);

    /**
     * 查看历史http类型job
     *
     * @param searchParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<HttpJobDetailVO> getHistoryHttpJobs(String searchParam, Integer pageSize, Integer pageNum);

    /**
     * 查看http类型的job执行记录
     *
     * @param jobName
     * @param jobGroup
     * @param searchParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<HttpJobLogs> getHttpJobLogs(String jobName, String jobGroup, String searchParam, Integer pageSize, Integer pageNum);
}
