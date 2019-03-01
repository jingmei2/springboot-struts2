package com.zfsoft.zftal.service;/**
 * Created by  Administrator on 2019-03-01 03:48 PM
 */

import com.zfsoft.zftal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @program: demo
 *
 * @description: UserService demo
 *
 * @author: Majing
 *
 * @create: 2019-03-01 15:48
 **/
@Service("userService")
public class UserService implements ServiceFacade {

    @Autowired
    private UserDao userDAO;
    @Override
    public Object doService(Object... args) throws Exception {
        Assert.notNull(args[0]);
        if(args[0].equals("insert")){
            userDAO.insertBatch();
            return true;
        }else{
            return userDAO.getUsers();
        }
    }
}
