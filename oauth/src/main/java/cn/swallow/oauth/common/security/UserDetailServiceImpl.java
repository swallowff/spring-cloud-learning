package cn.swallow.oauth.common.security;

import cn.swallow.oauth.model.SysRole;
import cn.swallow.oauth.model.SysUser;
import cn.swallow.oauth.service.SysRoleService;
import cn.swallow.oauth.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenyu
 * @create 2019/11/7
 */
@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService userInfoService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查找用户
        SysUser sysUser = userInfoService.getByUserName(username).get();
        if(sysUser == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SysRole> roleList = sysRoleService.findRoleByUserId(sysUser.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRole role : roleList){
            // 角色权限
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role.getName());
            authorities.add(authority);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(sysUser.getUserName());
        userInfo.setPassword(passwordEncoder.encode(sysUser.getUserPwd()));
        userInfo.setRoles(roleList);
        userInfo.setAuthorities(authorities);
        // 返回用户信息，注意加密
        return userInfo;
    }


}
