package com.yjt.demo.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class NetData {
    @Id
    String appName;

    @ElementCollection
    // 生成的表的主键Map.key+EmployeeMap_id
    @CollectionTable(name = "net_data_map")
    @MapKeyColumn(name = "data_key")
    @Column(name = "data_value",columnDefinition = "TEXT")
    private Map<String, String> others = new HashMap<String, String>();

    public NetData() {
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Map<String, String> getOthers() {
        return others;
    }

    public void setOthers(Map<String, String> others) {
        this.others = others;
    }
}
