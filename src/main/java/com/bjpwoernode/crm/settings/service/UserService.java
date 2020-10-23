package com.bjpwoernode.crm.settings.service;

import com.bjpwoernode.crm.settings.domain.User;
import com.bjpwoernode.crm.exception.LoginException;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
