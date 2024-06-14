package com.example.demo.controller;


import com.example.demo.entity.HttpJobDetailVO;
import com.example.demo.entity.HttpJobLogs;
import com.example.demo.entity.Page;
import com.example.demo.param.AddHttpJobParam;
import com.example.demo.response.Response;
import com.example.demo.service.HttpJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Http类型任务Controller
 *
 * @author hellofly
 * @date 2019/4/9
 */
@RestController
@RequestMapping(value = "/quartz/httpJob")
public class HttpJobController {

    @Autowired
    private HttpJobService httpJobService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response addPostJsonJob(@RequestBody @Valid AddHttpJobParam addHttpJobParam) {

        httpJobService.addHttpJob(addHttpJobParam);
        return Response.success();
    }

    @RequestMapping(value = "/jobs")
    public Response<Page<HttpJobDetailVO>> getJobs(@RequestParam(name = "searchParam", required = false) String searchParam,
                                                   @RequestParam(name = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

        Page<HttpJobDetailVO> result = httpJobService.getHttpJobs(searchParam, pageSize, pageNum);
        return Response.success(result);
    }

    @RequestMapping(value = "/historyJobs")
    public Response<Page<HttpJobDetailVO>> getHistoryJobs(@RequestParam(name = "searchParam", required = false) String searchParam,
                                                          @RequestParam(name = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                                          @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

        Page<HttpJobDetailVO> result = httpJobService.getHistoryHttpJobs(searchParam, pageSize, pageNum);
        return Response.success(result);

    }

    @RequestMapping(value = "/jobLogs")
    public Response<Page<HttpJobLogs>> getJobLogs(@RequestParam(name = "jobName", required = false) String jobName,
                                                  @RequestParam(name = "jobGroup", required = false) String jobGroup,
                                                  @RequestParam(name = "searchParam", required = false) String searchParam,
                                                  @RequestParam(name = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

        Page<HttpJobLogs> result = httpJobService.getHttpJobLogs(jobName, jobGroup, searchParam, pageSize, pageNum);
        return Response.success(result);
    }

}
