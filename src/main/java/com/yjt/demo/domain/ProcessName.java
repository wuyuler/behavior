package com.yjt.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProcessName {
    @Id
    String process_name;
    String appName;

    public ProcessName() {
    }

    public String getProcess_name() {
        return process_name;
    }

    public void setProcess_name(String process_name) {
        this.process_name = process_name;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
