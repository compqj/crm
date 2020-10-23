package com.bjpwoernode.crm.settings.dao;


import com.bjpwoernode.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {


    User login(Map<String, String> map);

    List<User> getUserList();
}
