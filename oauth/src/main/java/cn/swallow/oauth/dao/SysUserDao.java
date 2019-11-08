package cn.swallow.oauth.dao;

import cn.swallow.oauth.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser,Long> {
}
