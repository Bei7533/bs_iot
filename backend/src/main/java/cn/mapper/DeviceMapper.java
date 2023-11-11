package cn.mapper;

import cn.entity.Device;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

    @Select("SELECT * FROM device WHERE user_name IN (SELECT user_name FROM user WHERE user_name = #{username})")
    List<Device> selectDevicesByUsername(@Param("username") String username);

}
