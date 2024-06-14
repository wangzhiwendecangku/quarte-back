package com.example.demo.job;


import com.example.demo.constants.Constant;
import com.example.demo.entity.HttpJobLogs;
import com.example.demo.mapper.HttpJobLogsMapper;
import com.example.demo.util.HttpClientUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@DisallowConcurrentExecution
public class HttpPostFormDataJob implements Job {

    private static final Logger logger = LogManager.getLogger(HttpPostJsonJob.class);

    @Autowired
    private HttpJobLogsMapper httpJobLogsMapper;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String jobName = jobDetail.getKey().getName();
        String jobGroup = jobDetail.getKey().getGroup();

        Map<String, Object> jobParamsMap = jobDetail.getJobDataMap();

        String requestType = (String) jobParamsMap.get(Constant.REQUEST_TYPE);
        String url = (String) jobParamsMap.get(Constant.URL);
        Map<String, Object> formDataParamMap = (Map) jobParamsMap.get(Constant.PARAMS);

        HttpJobLogs httpJobLogs = new HttpJobLogs();
        httpJobLogs.setJobName(jobName);
        httpJobLogs.setJobGroup(jobGroup);
        httpJobLogs.setRequestType(requestType);
        httpJobLogs.setHttpUrl(url);
        if (null != formDataParamMap && formDataParamMap.size() > 0) {
            httpJobLogs.setHttpParams(formDataParamMap.toString());
        }

        String result = HttpClientUtil.postFormData(url, formDataParamMap);
        httpJobLogs.setResult(result);

        logger.info("Success in execute [{}_{}]", jobName, jobGroup);

        httpJobLogsMapper.insertSelective(httpJobLogs);
    }

}
