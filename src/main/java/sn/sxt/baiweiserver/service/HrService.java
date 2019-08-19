package sn.sxt.baiweiserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.sxt.baiweiserver.bean.Hr;
import sn.sxt.baiweiserver.mapper.HrMapper;
import sn.sxt.baiweiserver.mapper.RoleMapper;


@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户不存在!");
        }
        hr.setRoles(roleMapper.getRolesByHrid(hr.getId()));
        return hr;
    }
}
