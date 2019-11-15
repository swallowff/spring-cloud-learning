package cn.swallow.oauth.service;

import cn.swallow.oauth.model.SysUser;

import java.util.Optional;

public interface SysUserService {
    SysUser save(SysUser userInfo);

    SysUser getByUserName(String userName);

}
