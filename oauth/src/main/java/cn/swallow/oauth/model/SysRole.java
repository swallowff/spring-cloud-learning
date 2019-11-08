package cn.swallow.oauth.model;

import cn.swallow.oauth.common.constant.CommonDbStringDefine;
import cn.swallow.oauth.common.jpa.JpaAutoIdBaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author shenyu
 * @create 2019/11/8
 */
@Entity
@Table(name = "sys_role")
@Where(clause = CommonDbStringDefine.SOFT_DELETE_NORMAL_WHEHRE_CLAUSE)
public class SysRole extends JpaAutoIdBaseEntity<Integer> {
    private String name;
    private String roleName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
