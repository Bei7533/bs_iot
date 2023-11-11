package cn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;
import java.sql.Timestamp;

@TableName(value = "user")
@Entity
public class User {

    private String email;
    @Id
    private String username;
    private String password;
    private Timestamp last_login_time;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLoginTime() {
        return last_login_time;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.last_login_time = lastLoginTime;
    }
}
