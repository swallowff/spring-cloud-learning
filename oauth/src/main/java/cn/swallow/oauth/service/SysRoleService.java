package cn.swallow.oauth.service;

import cn.swallow.oauth.model.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> findRoleByUserId(Long userId);

}
