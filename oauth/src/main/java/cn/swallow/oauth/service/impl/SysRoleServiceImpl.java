package cn.swallow.oauth.service.impl;

import cn.swallow.oauth.dao.SysRoleDao;
import cn.swallow.oauth.model.SysRole;
import cn.swallow.oauth.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenyu
 * @create 2019/11/8
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findRoleByUserId(Long userId) {
        return sysRoleDao.findRoleByUserId(userId);
    }
}
