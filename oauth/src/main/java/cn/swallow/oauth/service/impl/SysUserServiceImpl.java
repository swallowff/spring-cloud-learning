package cn.swallow.oauth.service.impl;

import cn.swallow.oauth.dao.SysUserDao;
import cn.swallow.oauth.model.SysUser;
import cn.swallow.oauth.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author shenyu
 * @create 2019/11/7
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao userDao;

    @Override
    public SysUser save(SysUser userInfo) {
        return userDao.save(userInfo);
    }

    @Override
    public SysUser getByUserName(String userName) {
        SysUser query = new SysUser();
        query.setUserName(userName);
        Optional<SysUser> userOp = userDao.findOne(Example.of(query));
        if (userOp.isPresent()){
            return userOp.get();
        }else {
            return null;
        }
    }
}
