package com.zfsoft.zftal.controller;/**
 * Created by  Administrator on 2019-03-01 03:50 PM
 */


import com.opensymphony.xwork2.ActionSupport;
import com.zfsoft.zftal.dao.UserDao;
import com.zfsoft.zftal.model.User;
import com.zfsoft.zftal.service.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @program: demo
 *
 * @description: UserAction demo
 *
 * @author: Majing
 *
 * @create: 2019-03-01 15:50
 **/
@Component
public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<User> users;

    @Autowired
    private ServiceFacade userService;

    @SuppressWarnings("unchecked")
    @Override
    public String execute() throws Exception {
        users = (List<User>) userService.doService("get");
        return SUCCESS;
    }

    public List<User> getUsers(){
        return users;
    }
}