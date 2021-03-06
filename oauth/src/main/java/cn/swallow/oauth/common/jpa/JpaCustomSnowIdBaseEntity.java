package cn.swallow.oauth.common.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

import javax.persistence.OrderBy;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author swallowff
 * @create 2019/9/18
 */
@MappedSuperclass //表明这是父类，可以将属性映射到子类中使用JPA生成表
@DynamicUpdate //动态赋值
@DynamicInsert //动态插入
public abstract class JpaCustomSnowIdBaseEntity<ID> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "snow-id")   //使用自定义ID生成策略
    @GenericGenerator(name = "snow-id", strategy = "cn.swallow.oauth.common.util.JpaCustomIdGenerator")
    protected ID id;
    @CreationTimestamp
    @OrderBy("DESC")
    protected Date createTime;
    @UpdateTimestamp
    @OrderBy("DESC")
    protected Date updateTime;
    @JsonIgnore
    @Column
    protected boolean deleted;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
