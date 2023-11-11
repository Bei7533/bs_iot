package cn.mapper;

import cn.entity.Device;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

    @Select("SELECT * FROM device WHERE user_name IN (SELECT user_name FROM user WHERE user_name = #{username})")
    ArrayList<Device> selectDevicesByUsername(@Param("username") String username);

    @Update("UPDATE device SET device_name = #{deviceName} WHERE device_id = #{deviceId}")
    void updateDeviceName(@Param("deviceId") int deviceId, @Param("deviceName") String deviceName);

    @Update("UPDATE device SET device_type = #{deviceType} WHERE device_id = #{deviceId}")
    void updateDeviceType(@Param("deviceId") int deviceId, @Param("deviceType") String deviceType);

    @Update("UPDATE device SET device_discript = #{deviceDisc} WHERE device_id = #{deviceId}")
    void updateDeviceDisc(@Param("deviceId") int deviceId, @Param("deviceDisc") String deviceDisc);

    @Insert("INSERT INTO device (device_name, device_type, device_discript, user_name) VALUES (#{deviceName}, #{deviceType}, #{deviceDisc}, #{username})")
    void insertDevice(@Param("deviceName") String deviceName, @Param("deviceType") String deviceType,
            @Param("deviceDisc") String deviceDisc, @Param("username") String username);

    @Delete("DELETE FROM device WHERE device_id = #{deviceId}")
    void deleteDevice(@Param("deviceId") int deviceId);
}
