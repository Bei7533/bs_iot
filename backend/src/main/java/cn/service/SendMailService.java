package cn.service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import cn.api.CommonResult;
import cn.entity.User;
import cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
public class SendMailService {
    // 获取redis模板类
    @Autowired
    RedisTemplate redisTemplate;
    // 获取邮件发送类
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    UserMapper userMapper;

    // 异步请求
    @Async
    public CommonResult sendMail(String emailAddress) {
        // if(redisTemplate==null)
        // redisTemplate = new RedisTemplate();
        QueryWrapper<User> wrapper = new QueryWrapper();
        // wrapper.eq("email", emailAddress);
        List<User> uerList = userMapper.selectOneEmail(emailAddress);
        if (!uerList.isEmpty()) {
            System.out.println("not empty");
            return CommonResult.illegalemail("邮箱已经存在");
        }
        // 初始化邮件信息类
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("简单美丽的物联网设备管理系统的验证码");
        simpleMailMessage.setFrom("iot_admin_bei@163.com");
        simpleMailMessage.setTo(emailAddress);
        // 获取验证码
        String verification = generateCode();
        // 将验证码存放进邮箱
        simpleMailMessage.setText("这是你的验证码：\n" + verification);
        // 获取redis操作类
        // ValueOperations<String, String> valueOperations =
        // redisTemplate.opsForValue();
        javaMailSender.send(simpleMailMessage);
        VerificationCode.storeCode(verification, System.currentTimeMillis() + 60000);
        /* 设置缓存 */
        // valueOperations.set(emailAddress, verification);
        /**
         * K key, final long timeout, final TimeUnit unit
         * key 存储数据的key值
         * TimeUnit 时间单位
         * timeout 数据的过期时间
         */
        // 还没设置一分钟内只能发送一封的限制

        // redisTemplate.expire(emailAddress, 60 * 5, TimeUnit.SECONDS);
        return CommonResult.success("发送成功");
    }

    static public String generateCode() {
        Random random = new Random();
        char[] chars = new char[6];
        for (int i = 0; i < 6; i++) {
            Character c = null;
            c = (char) ('0' + random.nextInt('9' - '0' + 1));
            // System.out.println(c);
            chars[i] = c;
        }
        return String.valueOf(chars);
    }
}
