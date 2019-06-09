package com.sunyard.op.bean;

public class EurekaOperBean {
    //注册应用名
    String appName;
    //注册实例号
    String instanceID;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getInstanceID() {
        return instanceID;
    }

    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @Override
    public String toString() {
        return "EurekaOperBean{" +
                "appName='" + appName + '\'' +
                ", instanceID='" + instanceID + '\'' +
                '}';
    }
}
