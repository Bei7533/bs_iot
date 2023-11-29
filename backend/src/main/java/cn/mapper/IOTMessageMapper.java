package cn.mapper;

import cn.entity.IOTMessage;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.*;

@Mapper
public interface IOTMessageMapper extends BaseMapper<IOTMessage>  {

    @Insert("INSERT INTO IOTMessage (device_id, alert, lat, lng, log_time) VALUES (#{clientIdInt}, #{alertInt}, #{latFloat}, #{lngFloat}, #{sqlDate})")
    void insertMessage(@Param("clientIdInt") int clientIdInt, @Param("alertInt") int alertInt,
            @Param("latFloat") float latFloat, @Param("lngFloat") float lngFloat,
            @Param("sqlDate") java.sql.Timestamp sqlDate);

    @Select("SELECT * FROM IOTMessage WHERE device_id = #{deviceId}")
    ArrayList<IOTMessage> selectMessageByDeviceId(@Param("deviceId") int deviceId);

    @Select("SELECT * FROM IOTMessage WHERE device_id = #{deviceId} ORDER BY log_time DESC LIMIT 1")
    IOTMessage selectLatestMessage(@Param("deviceId") int deviceId);

}