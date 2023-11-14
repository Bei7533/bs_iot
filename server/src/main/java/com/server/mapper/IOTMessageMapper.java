package com.server.mapper;

import com.server.entity.IOTMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IOTMessageMapper extends BaseMapper<IOTMessage> {

    @Insert("INSERT INTO IOTMessage (device_id, alert, lat, lng, log_time) VALUES (#{clientIdInt}, #{alertInt}, #{latFloat}, #{lngFloat}, #{sqlDate})")
    void insertMessage(@Param("clientIdInt") int clientIdInt, @Param("alertInt") int alertInt,
            @Param("latFloat") float latFloat, @Param("lngFloat") float lngFloat,
            @Param("sqlDate") java.sql.Timestamp sqlDate);
}
