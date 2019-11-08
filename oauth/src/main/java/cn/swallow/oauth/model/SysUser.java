package cn.swallow.oauth.model;

import cn.swallow.oauth.common.constant.CommonDbStringDefine;
import cn.swallow.oauth.common.jpa.JpaAutoIdBaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author shenyu
 * @create 2019/11/7
 */
@Entity
@Table(name = "sys_user")
@Where(clause = CommonDbStringDefine.SOFT_DELETE_NORMAL_WHEHRE_CLAUSE)
public class SysUser extends JpaAutoIdBaseEntity<Long> {
    @Column
    private String userName;
    @Column
    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
