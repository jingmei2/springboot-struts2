package com.zfsoft.zftal.dao;/**
 * Created by  Administrator on 2019-03-01 03:43 PM
 */

import com.zfsoft.zftal.model.User;

import java.util.List;

/**
 * @program: demo
 *
 * @description: UserDao
 *
 * @author: Majing
 *
 * @create: 2019-03-01 15:43
 **/
public interface UserDao {
    public List<User> getUsers();
    public void insertBatch();
}
