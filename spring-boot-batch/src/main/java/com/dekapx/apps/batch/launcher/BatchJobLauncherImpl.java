package com.dekapx.apps.batch.launcher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BatchJobLauncherImpl implements BatchJobLauncher {
    private JobLauncher jobLauncher;
    private Job processJob;

    @Autowired
    public BatchJobLauncherImpl(JobLauncher jobLauncher, Job processJob) {
        this.jobLauncher = jobLauncher;
        this.processJob = processJob;
    }

    @Override
    public void triggerJob() {
        log.info("-------------- BatchInvoker.invoke --------------");
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(processJob, jobParameters);
            log.info("Batch job invoked...");
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            log.error("Exception while executing the batch...", e);
        }
    }
}
