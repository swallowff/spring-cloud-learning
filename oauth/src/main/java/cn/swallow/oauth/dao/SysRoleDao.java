package cn.swallow.oauth.dao;

import cn.swallow.oauth.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysRoleDao extends JpaRepository<SysRole,Integer> {

    //TODO
    @Query(nativeQuery = true,value = "SELECT b.id,b.name,b.role_name,b.create_time,b.update_time,b.deleted FROM sys_user_role a LEFT JOIN sys_role b ON b.id = a.role_id AND b.deleted = 0 WHERE a.user_id = ?1 AND a.deleted = 0 ")
    List<SysRole> findRoleByUserId(Long userId);
}
