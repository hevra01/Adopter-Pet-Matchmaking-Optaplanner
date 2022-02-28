package com.beartell.animalmatchmaking.scheduler;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class JobData {

    private String jobName;
    private String jobGroup;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime starTime;
    private int counter;
    private int gapDuration;

    public JobData(String jobName, String jobGroup, LocalDateTime starTime, int counter, int gapDuration) {
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.starTime = starTime;
        this.counter = counter;
        this.gapDuration = gapDuration;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public LocalDateTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalDateTime starTime) {
        this.starTime = starTime;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getGapDuration() {
        return gapDuration;
    }

    public void setGapDuration(int gapDuration) {
        this.gapDuration = gapDuration;
    }

}
