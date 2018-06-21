package com.chinasoft.service;

import com.chinasoft.data.entity.User;
import com.chinasoft.data.model.ServerResponse;
import com.chinasoft.data.model.UserQo;
import com.chinasoft.data.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;

/**
 * Created by liuhengtao.
 */
@Service
public class SysUserService {
    private static Logger logger = LoggerFactory.getLogger(SysUserService.class);

    @Autowired
    UserRepository sysUserRepository;

    private  static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    /**
     * 注册
     * @param user
     * @return
     */
    public ServerResponse<User> register(UserQo user) {
        User loginNameGet = sysUserRepository.findByLoginName(user.getLoginName());
        User mobiLePhoneGet = sysUserRepository.findByMobilePhone(user.getMobilePhone());
        if (user.getLoginName() == null) {
            return ServerResponse.createByErrorMessage("用户名为空");
        }
        if (loginNameGet != null) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        if (mobiLePhoneGet != null) {
            return ServerResponse.createByErrorMessage("手机号已存在");
        }

        if (user.getPassword() == null) {
            return ServerResponse.createByErrorMessage("密码为空");
        }
        if (user.getMobilePhone() == null) {
            return ServerResponse.createByErrorMessage("手机号为空");
        }
        return ServerResponse.createBySuccess();
    }

}


