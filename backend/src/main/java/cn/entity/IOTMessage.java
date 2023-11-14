package cn.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@TableName(value = "IOTMessage")
@Entity
public class IOTMessage {
    @Id
    private Long log_id;
    private String device_id;
    // 是否告警，0-正常，1-告警
    private int alert;
    // 设备位置，纬度
    private float lat;
    // 设备位置，经度
    private float lng;
    // 上报时间，ms
    private Timestamp log_time;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public int getAlert() {
        return alert;
    }

    public void setAlert(int alert) {
        this.alert = alert;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public Timestamp getTimestamp() {
        return log_time;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.log_time = timestamp;
    }

    @Override
    public String toString() {
        return "{device_id:" + device_id + ",alert:" + alert + ",lat:" + lat + ",lng:"
                + lng + ",log_time:" + log_time + "}";
    }
}
