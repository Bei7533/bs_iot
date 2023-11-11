package cn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@TableName(value = "IOTMessage")
@Entity
public class IOTMessage {
    @Id
    private Long log_id;

    private String device_id;
    // 上报信息
    private String info;
    // 设备数据
    private int value;
    // 是否告警，0-正常，1-告警
    private int alert;
    // 设备位置，纬度
    private double lat;
    // 设备位置，经度
    private double lng;
    // 上报时间，ms
    private long timestamp;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getAlert() {
        return alert;
    }

    public void setAlert(int alert) {
        this.alert = alert;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
