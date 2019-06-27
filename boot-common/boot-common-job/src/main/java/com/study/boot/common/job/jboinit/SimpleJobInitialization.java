package com.study.boot.common.job.jboinit;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.study.boot.common.job.properties.ElasticJobProperties;

import java.util.Map;

/**
 * 简单任务初始
 * @author Administrator
 */

public class SimpleJobInitialization extends AbstractJobInitialization {

    private Map<String, ElasticJobProperties.SimpleConfiguration> simpleConfigurationMap;

    public SimpleJobInitialization(final Map<String, ElasticJobProperties.SimpleConfiguration> simpleConfigurationMap) {
        this.simpleConfigurationMap = simpleConfigurationMap;
    }

    public void init() {
        for (String jobName : simpleConfigurationMap.keySet()) {
            ElasticJobProperties.SimpleConfiguration configuration = simpleConfigurationMap.get(jobName);
            initJob(jobName, configuration.getJobType(), configuration);
        }
    }

    @Override
    public JobTypeConfiguration getJobTypeConfiguration(String jobName, JobCoreConfiguration jobCoreConfiguration) {
        ElasticJobProperties.SimpleConfiguration configuration = simpleConfigurationMap.get(jobName);
        return new SimpleJobConfiguration(jobCoreConfiguration,configuration.getJobClass());
    }
}
